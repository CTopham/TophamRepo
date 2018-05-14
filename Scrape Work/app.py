from flask import Flask, render_template, jsonify, redirect
from flask_pymongo import PyMongo
import scrape_mars

# create instance of Flask app
app = Flask(__name__)

mongo = PyMongo(app)

@app.route("/")
def index():
    listing = mongo.db.listing.find_one()
    return render_template("index.html", listing=listing)


@app.route("/scrape")
def scrape():
    listing = mongo.db.listing
    listing_data = scrape_mars.scrape()
    listing.update(
        {},
        listing_data,
        upsert=True
    )
    return redirect("http://localhost:5000/", code=302)




if __name__ == "__main__":
    app.run(debug=True)
    