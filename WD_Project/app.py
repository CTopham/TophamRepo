import os
import json
import datetime as dt
import sqlalchemy
import pandas as pd
from sqlalchemy.ext.automap import automap_base
from sqlalchemy.orm import Session
from sqlalchemy import create_engine, func
from flask import Flask, jsonify
import pandas as pd
import pprint
import json
import numpy as np
from flask import (
    Flask,
    render_template,
    jsonify,
    request
    )

from flask_sqlalchemy import SQLAlchemy

#################################################
# Database Setup
#################################################
engine = create_engine("sqlite:///wd.sqlite")

# reflect an existing database into a new model
Base = automap_base()

# reflect the tables
Base.prepare(engine, reflect=True)

# Save references to the sample and sample meta tables
wd_base = Base.classes.wd

# Create our session (link) from Python to the DB
session = Session(engine)

app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = "sqlite:///wd.sqlite"

@app.route("/")
def home():
    """Render Home Page."""
    return render_template("Landing.html")

@app.route("/Table")
def Table():
    """Render Home Page."""
    return render_template("Datatable.html")

@app.route("/Leaflet")
def Leaflet():
    """Render Home Page."""
    return render_template("Leaflet.html")

@app.route("/Machine")
def Machine():
    """Render Home Page."""
    return render_template("Machine.html")

@app.route("/api")
def api():
    """Return a list of passenger data including the name, age, and sex of each passenger"""
    # Query all passegers
    results = session.query(wd_base).all()

    # Create a dictionary from the row data and append to a list of all_wds
    all_wds = []
    for wd in results:
        wd_dict = {}
        wd_dict["Type"] = wd.Type
        wd_dict["Rating"] = wd.Rating
        wd_dict["Latitude"] = wd.Latitude
        wd_dict["Longitude"] = wd.Longitude
        wd_dict["Year"] = wd.Year
        wd_dict["Magnitude"] = wd.Magnitude
        wd_dict["Mass"] = wd.Mass
        wd_dict["VEI"] = wd.VEI
        all_wds.append(wd_dict)

    return jsonify(all_wds)


@app.route("/Volcano")
def Volcano():
    """Return emoji score and emoji char"""

    # query for the top 10 emoji data
    results = session.query(wd_base.VEI, wd_base.Year ).\
    filter(wd_base.Year > 1900).\
    filter(wd_base.Year < 2018).\
    order_by(wd_base.Year.desc())
   

    # Select the top 10 query results
    vei = [result[0] for result in results]
    year = [int(result[1]) for result in results]

    # Generate the plot trace
    plot_trace = {
        "x": year,
        "y": vei,
        "type": "line"
    }
    return jsonify(plot_trace)
   
@app.route("/Earthquake")
def Earthquake():
    """Return emoji score and emoji char"""

    # query for the top 10 emoji data
    results = session.query(wd_base.Magnitude, wd_base.Year ).\
    filter(wd_base.Year > 1960).\
    filter(wd_base.Year < 2018).\
    order_by(wd_base.Year.desc())
   

    # Select the top 10 query results
    Magnitude = [result[0] for result in results]
    year = [int(result[1]) for result in results]

    # Generate the plot trace
    plot_trace = {
        "x": year,
        "y": Magnitude,
        "type": "line"
    }
    return jsonify(plot_trace)

@app.route("/Meteor")
def Meteor():
    """Return emoji score and emoji char"""

    # query for the top 10 emoji data
    results = session.query(wd_base.Mass, wd_base.Year ).\
    filter(wd_base.Year > 1960).\
    filter(wd_base.Year < 2018).\
    order_by(wd_base.Year.desc())
   

    # Select the top 10 query results
    Mass = [result[0] for result in results]
    year = [int(result[1]) for result in results]

    # Generate the plot trace
    plot_trace = {
        "x": year,
        "y": Mass,
        "type": "line"
    }
    return jsonify(plot_trace)


if __name__ == '__main__':
    app.run(debug=True)