# import necessary libraries
import numpy as np
import os

from sqlalchemy.ext.automap import automap_base
from sqlalchemy.orm import Session
from sqlalchemy import create_engine, func

from flask import (
    Flask,
    render_template,
    jsonify,
    request,
    redirect)
import tweepy
from flask_sqlalchemy import SQLAlchemy

#################################################
# Flask Setup
#################################################
app = Flask(__name__)

#################################################
# Database Setup
#################################################
from flask_sqlalchemy import SQLAlchemy
app.config['SQLALCHEMY_DATABASE_URI'] = os.environ.get('DATABASE_URL', '') or "sqlite:///babies.sqlite"
# app.config['SQLALCHEMY_DATABASE_URI'] = os.environ.get('DATABASE_URL', '')
db = SQLAlchemy(app)

class Baby (db.Model):
    __tablename__ = 'babies'

    id = db.Column(db.Integer, primary_key=True)
    Decade = db.Column(db.Integer)
    Males = db.Column(db.Text)
    num_boys=db.Column(db.Integer)
    Females = db.Column(db.Text)
    num_girls=db.Column(db.Integer)

    def __repr__(self):
        return f"id={self.id}, name={self.name}"


#@app.before_first_request
#def setup():
    # Recreate database each time for demo
    #db.drop_all()
    #db.create_all()


# create route that renders index.html template
@app.route("/")
def home():
    return render_template("Cloud.html")
    
@app.route("/api")
def api():
    return jsonify("/static/data.js")

@app.route("/table")
def tablebaby():
    return render_template("table.html")
@app.route("/wire")
def wire():
    return render_template("wirechart.html")
@app.route("/scroll")
def scroll():
    return render_template("lil_scroll.html")

@app.route("/search")
def baby():
    return render_template("babysearch.html")

# Query the database and send the jsonified results
@app.route("/send", methods=["GET", "POST"])
def send():
    if request.method == "POST":
        name = request.form["findName"]

        years={"girls":[],"boys":[]}
        years["boys"] = db.session.query(Baby.Decade).filter(Baby.Males==name).all()
        years["girls"] = db.session.query(Baby.Decade).filter(Baby.Females==name).all()
        #if years["boys"]
        responses=[]
        responses.append("Never. Now is the time to start advocating for this name!")
        responses.append("Never. Are you sure this is a good name for a baby?")
        responses.append("Never. If this is your name, then you truly are a unique fish in a sea of commonality.")
        responses.append("Never. 130 years of people avoiding this name.")
        responses.append("Never. A rose by any other name would smell as sweet, but this name kind of stinks.")
        responses.append("Never. Wear your individuality as a badge of honor.")
        responses.append("Never. I can't believe it. It is such a good name. No, I'm not being sarcastic at all.")
        responses.append("Never. I had a cousin with this name, so there's that.")
        responses.append("Never. Just . . . never.")

        gender = ""
        answer = []
        if (len(years["boys"])==0 and len(years["girls"])==0):
            which_resp = np.random.randint(len(responses))
            answer=responses[which_resp]
            gender="boy or girl"
        else:
            if len(years["boys"])==0:
                which_resp = np.random.randint(len(responses))
                for i in years["girls"]:
                    answer.append(i[0])
                gender = "girl"
            if len(years["girls"])==0:
                which_resp = np.random.randint(len(responses))
                for i in years["boys"]:
                    answer.append(i[0])
                #answer=years["boys"]
                gender = "boy"
        

        # Twitter API Keys
        consumer_key = "Ed4RNulN1lp7AbOooHa9STCoU"
        consumer_secret = "P7cUJlmJZq0VaCY0Jg7COliwQqzK0qYEyUF9Y0idx4ujb3ZlW5"
        access_token = "839621358724198402-dzdOsx2WWHrSuBwyNUiqSEnTivHozAZ"
        access_token_secret = "dCZ80uNRbFDjxdU2EckmNiSckdoATach6Q8zb7YYYE5ER"

        # Setup Tweepy API Authentication
        auth = tweepy.OAuthHandler(consumer_key, consumer_secret)
        auth.set_access_token(access_token, access_token_secret)
        api = tweepy.API(auth, parser=tweepy.parsers.JSONParser())

        # Search Term
        search_term = name

        # Search for all tweets
        public_tweets = api.search(search_term, rpp=1)
        # View Search Object

        tweeting_name=""
        tweeting_name = public_tweets["statuses"][0]["text"]
        
        a = api.get_status(int(public_tweets["statuses"][0]['id']), tweet_mode='extended')

        link = ""
        if(public_tweets["statuses"][0].get('entities').get('urls')):
            url = public_tweets["statuses"][0].get('entities').get('urls')[0]['url']
            link = "Find more info at "+url
            #print(link)

        
        return render_template('babysearch.html', name=name, answer=answer, gender = gender, tweeting_name=a['full_text'],additional=link)

#This part said render form.html in the pet pals thing
    return render_template("babysearch.html")
    #return render_template('babysearch.html', {'boys': years["boys"],'girls': years["girls"]})


if __name__ == "__main__":
    app.run()