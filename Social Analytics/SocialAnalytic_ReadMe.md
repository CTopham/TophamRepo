

```python
#Analyzing the news sentiment
#BBC, CBS, CNN, Fox, and New York times.
#The first plot: scatter from the past 100 tweets of each outlet, each plot is the compound. sort by time stamp
#second plot: bar plot of overall sentiment of each outlet,  aggregate the compound sentiment

#Dependencies
import json
import tweepy
import numpy as np
import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt
import time
from datetime import datetime
from textblob import TextBlob
import matplotlib.patches as mpatches

#Keys to the kingdom
from config import Consumer
from config import ConsumerSecret
from config import Access
from config import AccessSecret

# Setup Tweepy API Authentication
auth = tweepy.OAuthHandler(Consumer, ConsumerSecret)
auth.set_access_token(Access, AccessSecret)
api = tweepy.API(auth, parser=tweepy.parsers.JSONParser())

#Vader for the sentiment analytics
from vaderSentiment.vaderSentiment import SentimentIntensityAnalyzer
analyzer = SentimentIntensityAnalyzer()
```


```python
target_tags = ["@BBC", "@CBS", "@CNN", "@FoxNews","@nytimes"]
```


```python
#Pulling data from Twitter API
counter = 0
sentiments = []
while counter < 4:
    for tag in target_tags:
        target_user = tag
        tweet_count = 0
        for x in range(5):
            public_tweets = api.user_timeline(target_user)
            for tweet in public_tweets:
                compound = analyzer.polarity_scores(tweet["text"])["compound"]
                pos = analyzer.polarity_scores(tweet["text"])["pos"]
                neu = analyzer.polarity_scores(tweet["text"])["neu"]
                neg = analyzer.polarity_scores(tweet["text"])["neg"]
                raw_time = tweet["created_at"]
                converted_time = datetime.strptime(raw_time, "%a %b %d %H:%M:%S %z %Y")
                words = tweet["text"]
                print(analyzer.polarity_scores(tweet["text"]))
                sentiments.append({"Date": converted_time,
                                   "Tweet": words,
                                   "Compound": compound,
                                   "Positive": pos,
                                   "Negative": neu,
                                   "Neutral": neg,
                                   "Outlet": tag,
                                   "Tweets Ago": tweet_count,})
                counter = counter + 1 
                tweet_count = tweet_count + 1
                converted_time = []
                words = []


```


```python
sentiments_pd = pd.DataFrame.from_dict(sentiments)
sentiments_pd.head()
```


```python
#Re-ordering the DataFrame
sentiments_pd = sentiments_pd[["Outlet", "Date", "Tweet", "Compound", "Positive", "Neutral", "Negative", "Tweets Ago"]]
sentiments_pd.tail()
```


```python
#Checking to ensure I pulled all outlets
sentiments_pd["Outlet"].unique()
```


```python
#Sorting by date
sentiments_pd= sentiments_pd.sort_values("Date", ascending=False)
```


```python
#Plotting
import seaborn as sns
sns.set_style("whitegrid")
plt.figure(figsize=(20,5))
plt.title("Tweet Sentiment")
plt.xlabel('Tweets Ago')
plt.ylabel('Tweet Polarity')

bbc = sentiments_pd.loc[sentiments_pd["Outlet"] == "@BBC",:]
plt.scatter(bbc["Tweets Ago"], bbc["Compound"], c='darkviolet', s=100, alpha=0.5, edgecolors="grey", linewidth=1)

cbs = sentiments_pd.loc[sentiments_pd["Outlet"] == "@CBS",:]
plt.scatter(cbs["Tweets Ago"], cbs["Compound"], c='lime', s=100, alpha=0.5, edgecolors="grey", linewidth=1,)

cnn = sentiments_pd.loc[sentiments_pd["Outlet"] == "@CNN",:]
plt.scatter(cnn["Tweets Ago"], cnn["Compound"], c='red', s=100, alpha=0.5, edgecolors="grey", linewidth=1,)

FoxNews = sentiments_pd.loc[sentiments_pd["Outlet"] == "@FoxNews",:]
plt.scatter(FoxNews["Tweets Ago"], FoxNews["Compound"], c='Orange', s=100, alpha=0.5, edgecolors="grey", linewidth=1,)

NYTimes = sentiments_pd.loc[sentiments_pd["Outlet"] == "@nytimes",:]
plt.scatter(NYTimes["Tweets Ago"], NYTimes["Compound"], c='Navy', s=100, alpha=0.5, edgecolors="grey", linewidth=1,)

BBC = mpatches.Patch(color='darkviolet', label='BBC')
CBS = mpatches.Patch(color='lime', label='CBS')
CNN = mpatches.Patch(color='red', label='CNN')
FoxNews = mpatches.Patch(color='Orange', label='FoxNews')
NYTimes = mpatches.Patch(color='Navy', label='NYTimes')
plt.legend(handles=[BBC,CBS,CNN,FoxNews,NYTimes], loc=1)
plt.savefig("Compound_Scatter.png")
plt.show()

```


```python
#Grouping by outlet then creating a new DF for the bar chart
bar_prep = sentiments_pd.groupby(['Outlet'],as_index=False).mean()[['Outlet','Compound']]
bar_prep.head()
```


```python
#Bar Chart
sns.set_style("whitegrid")
plt.figure(figsize=(20,5))
plt.title("Average Media Sentiment 03/30/2018")
plt.xlabel('News Outlet')
plt.ylabel('Tweet Polarity')
my_colors = 'rgbkymc'
#Ticks
x_axis = np.arange(len(bar_prep["Outlet"]))
tick_locations = [value+0.4 for value in x_axis]
#Plot
plt.bar(x_axis, bar_prep["Compound"], color=my_colors, alpha=0.5, align="edge")
plt.xticks(tick_locations, bar_prep["Outlet"], rotation="vertical")

plt.savefig("Compound_Bar.png")
plt.show()
```


```python
writer = pd.ExcelWriter('output.xlsx',options={'remove_timezone': True})
sentiments_pd.to_excel(writer,'Sheet1')
```


```python
# Three Trends:
# 1) CBS usually has higher positive sentiment
# 2) Fox usually has negative sentiment
# 3) NYTimes/BBC is in the middle normally

```


```python
#End of code 
```
