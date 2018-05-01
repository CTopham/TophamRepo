#Normal Analytics Dependencies
import matplotlib
import pandas as pd
import numpy as np
matplotlib.use('nbagg')
import matplotlib.pyplot as plt
from matplotlib import style
import datetime as dt
import datetime
from sqlalchemy.orm import Session
import seaborn as sns
style.use('seaborn')

#ORM Dependencies
import sqlalchemy
from sqlalchemy import create_engine, MetaData
from sqlalchemy import create_engine, Column, Integer, String, Float, inspect, MetaData, func
from sqlalchemy.ext.automap import automap_base

#Creating Engine for Database
engine = create_engine("sqlite:///Hawaii.sqlite", echo=False)
inspector = inspect(engine)
from flask import Flask, jsonify

#Prepping Base
Base = automap_base()
Base.prepare(engine, reflect=True)

#Bringing in classes
Measurement = Base.classes.Measurement
Station = Base.classes.Station

#Starting work horse
session = Session(engine)

#==============================================================
#Starting Flask
app = Flask(__name__)
#==============================================================

@app.route("/")
def welcome():
    """List all available api routes."""
    return (
        f"Avalable Routes:<br/>"
        f"/api/v1.0/Precipitation<br/>"

        f"/api/v1.0/Stations<br/>"
        f"- List Stations and their total observations<br/>"

        f"/api/v1.0/TOBS<br/>"
        f"- Temperature Observations<br/>"

        f"/api/v1.0/2016-08-23<br/>"
        f"- Date selection of Temperature data (Defaults to 1 year of data)<br/>"

        f"/api/v1.0/2016-08-23/2016-08-27<br/>"
        f"- Temperature data between two dates<br/>"

    )

@app.route("/api/v1.0/Precipitation")
def Precipitation():
    """Returns precipitation data from last year"""
    prcp_data = session.query(Measurement.date,Measurement.prcp).\
    filter(Measurement.date > '2016-08-23').\
    order_by(Measurement.date).all()
    Precip_list = list(np.ravel(prcp_data))

    return jsonify(Precip_list)

@app.route("/api/v1.0/Stations")
def Stations():
    """Returns precipitation data from last year"""
    Station_data = session.query(Measurement.station,func.count(Measurement.tobs)).\
    group_by(Measurement.station).\
    order_by(func.sum(Measurement.tobs).desc()).all()
    Station_list = list(np.ravel(Station_data))

    return jsonify(Station_list)

@app.route("/api/v1.0/TOBS")
def TOBS():
    """Returns precipitation data from last year"""
    tobs_data = session.query(Measurement.station,Measurement.tobs).\
    filter(Measurement.date > '2016-08-23').all()
    tobs_list = list(np.ravel(tobs_data))

    return jsonify(tobs_list)


@app.route("/api/v1.0/<start>")
def Starts(start="2016-08-23"):
    """Returns temperature data from a time selected"""
    start_data = session.query(Measurement.station,Measurement.tobs).\
    filter(Measurement.date > start).all()
    start_list = list(np.ravel(start_data))

    return jsonify(start_list)


@app.route("/api/v1.0/<start>/<end>")
def Start_end_date(start="2016-08-23", end = "2017-08-27"):
    """Returns temperature data between dates selected"""
    start_end = session.query(Measurement.station,Measurement.tobs,Measurement.date).\
    filter(func.strftime("%Y-%m-%d", Measurement.date) >= start).\
    filter(func.strftime("%Y-%m-%d", Measurement.date) <= end).\
    group_by(Measurement.date).\
    order_by(Measurement.tobs).all()
    start_end_list = list(np.ravel(start_end))
    return jsonify(start_end_list)


if __name__ == '__main__':
    app.run()

