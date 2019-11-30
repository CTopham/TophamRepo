from flask import Flask, render_template, jsonify, redirect, request
from flask_pymongo import PyMongo
import scraper
import pymongo
from shodan import Shodan
from Config import API
import shodan


# This file is used to initiate the the server via flask. once the server is up and running you can navigate through the routes defined
# the app route annotations work much like spring framework in java that is used in the controller class.
# Future improvements
    # make it so it can dynamically click IP
    # make it so catalog isnt hard coded
    # make it so the api text is legible

# create instance of Flask app
app = Flask(__name__)
app.config["MONGO_URI"] = "mongodb://localhost:27017/visipedia_annotation_toolkit"
mongo = PyMongo(app)


@app.route("/")
def index():
    listing = mongo.db.listing.find_one()
    return render_template("index.html", listing=listing)

@app.route("/catalog", methods=['GET'])
def catalog():
    ipset = request.get_json()
    return render_template("catalog.html", ipset=ipset)

@app.route("/video")
def video():
    listing = mongo.db.listing.find_one()
    return render_template("video.html", listing=listing)

@app.route("/tweet")
def tweet():
    listing = mongo.db.listing
    listing_data = scraper.tweet()
    listing.update(
        {},
        listing_data,
        upsert=True
    )
    return redirect("http://localhost:5000/", code=302)


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
    item = API_KEY.host('217.182.92.56')
    # host_name = socket.gethostname() 
    # host_ip = socket.gethostbyname(host_name)
    return render_template("ipcheck.html", item=item)


if __name__ == "__main__":
    app.run(debug=True)
    