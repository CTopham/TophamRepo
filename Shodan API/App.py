from flask import Flask, render_template, jsonify, redirect
from flask_pymongo import PyMongo
import scraper
import pymongo
from shodan import Shodan
from Config import API

# create instance of Flask app
app = Flask(__name__)
app.config["MONGO_URI"] = "mongodb://localhost:27017/visipedia_annotation_toolkit"
mongo = PyMongo(app)

@app.route("/")
def index():
    listing = mongo.db.listing.find_one()
    return render_template("index.html", listing=listing)


@app.route("/scrape")
def scrape():
    listing = mongo.db.listing
    listing_data = scraper.scrape()
    listing.update(
        {},
        listing_data,
        upsert=True
    )
    return redirect("http://localhost:5000/", code=302)

@app.route("/ipcheck")
def ipcheck():
    API_KEY  = Shodan(API)
    item = API_KEY.host('174.72.222.20')
    # host_name = socket.gethostname() 
    # host_ip = socket.gethostbyname(host_name)

    return render_template("ipcheck.html", item=item)


if __name__ == "__main__":
    app.run(debug=True)
    