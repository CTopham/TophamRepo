

```python
#Install omdb library
!pip install omdb

#Dependencies
import pandas as pd
import numpy as np
#import os as os
#import csv
import json
import math
import seaborn as sns
import matplotlib.pyplot as plt
import requests
import json
import omdb
import time

from pprint import pprint
from config import omdb_key

# Import and Initialize Sentiment Analyzer
from vaderSentiment.vaderSentiment import SentimentIntensityAnalyzer
analyzer = SentimentIntensityAnalyzer()
```


```python
#Pulling in Data
csv_path = "Resources/tmdb_5000_credits.csv"
csv_path2 = "Resources/tmdb_5000_movies.csv"
movie_actor_df=pd.read_csv("Resources\movies_actors.csv")
movies_money_df=pd.read_csv("Resources\movies.csv")
actors = pd.read_csv(csv_path, encoding="utf-8")
movies = pd.read_csv(csv_path2, encoding="utf-8")
actors_df = pd.read_csv(csv_path)
```

# Numbers of movies released through years
The chart below shows total number of movies from the original (not cleaned) dataset. All unique entries except 4 candidates for duplicates.


```python

movies = pd.read_csv("Resources/tmdb_5000_movies.csv")
movies_df = pd.DataFrame(movies)
movies_df['Release Year']=movies_df['release_date'].str[:4].astype(float)

movies_count_by_year=movies_df.groupby(by="Release Year")["title"].count().reset_index().rename(columns={"title":"Released Movies Count"})

sns.set_style(style='whitegrid',rc={'axes.linewidth': 2.0, 'legend.frameon': True, 'grid.linestyle': u'--',  'legend.scatterpoints': 1, 'font.size': 10, 'axes.labelsize': 10, 'legend.fontsize': 10, 'axes.titlesize': 8, 'xtick.labelsize': 12, 'ytick.labelsize': 10})
plt.figure(figsize=(10,6)) # updated
movies_count_by_year.plot(x="Release Year",y="Released Movies Count", ax = plt.gca()) # updated
plt.xticks(np.arange(1900,2021,10))
plt.yticks(np.arange(0,250,25))
plt.title("Numbers of Movie Releases Over the Years")# added
plt.savefig("Images/Numbers of Movie Releases Over the Years.png",dpi=300) #added
plt.show()
```

# Buckets by Release Year
Because of large difference in numbers of movies released over the years, the movies are broken down into release year buckets.


```python
#updated
year_buckets=[1960,1995]
movie_year_bucket=[]
movie_year_bucket_no=[]
year_buckets_labels=[]
for i in range(0,len(year_buckets)+1):
    if i==0:
        year_buckets_labels.append("before "+str(year_buckets[0]))
    elif i==len(year_buckets):
        year_buckets_labels.append("after "+str(year_buckets[-1]))
    else:
        year_buckets_labels.append(str(year_buckets[i-1])+" to "+str(year_buckets[i]))

for index,row in movies_money_df.iterrows():
    if row["Release Year"]<year_buckets[0]:
        movie_year_bucket.append(year_buckets_labels[0])
        movie_year_bucket_no.append(1)
    elif row["Release Year"]>=year_buckets[-1]:
        movie_year_bucket.append(year_buckets_labels[-1])
        movie_year_bucket_no.append(len(year_buckets)+1)
    else:
        ok=False
        for i in range(len(year_buckets)-1):
            if(year_buckets[i]<=row["Release Year"]<year_buckets[i+1]):
                movie_year_bucket.append(year_buckets_labels[i+1])
                movie_year_bucket_no.append(i+2)                
                ok=True
        if(ok==False):
            movie_year_bucket.append("undefined")
            movie_year_bucket_no.append(0)
            
movies_money_df["Years"]=movie_year_bucket
movies_money_df["Release Years Bucket"]=movie_year_bucket_no
year_buckets_labels
```

# Buckets by Budget
Because of large difference in budgets, we break down movies into budget buckets


```python
#modified, replace budget to budget
budget_buckets=[0.5,10,100] #updated
budget_bucket=[]
budget_bucket_no=[]
budget_buckets_labels=[]
units_str="USD mln"
for i in range(0,len(budget_buckets)+1):
    if i==0:
        budget_buckets_labels.append("<"+str(budget_buckets[0])+" "+units_str)
    elif i==len(budget_buckets):
        budget_buckets_labels.append(">"+str(budget_buckets[-1])+" "+units_str)
    else:
        budget_buckets_labels.append(str(budget_buckets[i-1])+"-"+str(budget_buckets[i])+" "+units_str)
        
for index,row in movies_money_df.iterrows():
    if row["Budget Adjusted, USD mln"]<budget_buckets[0]:
        budget_bucket.append(budget_buckets_labels[0])
        budget_bucket_no.append(1)
    elif row["Budget Adjusted, USD mln"]>=budget_buckets[-1]:
        budget_bucket.append(budget_buckets_labels[-1])
        budget_bucket_no.append(len(budget_buckets)+1)
    else:
        ok=False
        for i in range(len(budget_buckets)-1):#updated
            if(budget_buckets[i]<=row["Budget Adjusted, USD mln"]<budget_buckets[i+1]):
                budget_bucket.append(budget_buckets_labels[i+1])
                budget_bucket_no.append(i+2)
                ok=True
        if(ok==False):
            budget_bucket.append("undefined")
            budget_bucket_no.append(0)
            

movies_money_df["Budget Tier"]=budget_bucket
movies_money_df["Budget Tier No"]=budget_bucket_no
budget_buckets_labels
```

# Revenues by release year and revenue tiers


```python
g = sns.FacetGrid(movies_money_df[~movies_money_df["Outlier"]], row="Budget Tier", row_order=list(reversed(budget_buckets_labels)), col="Years", col_order=year_buckets_labels, sharex=False, sharey=False, hue="Budget Tier", hue_order=list(reversed(budget_buckets_labels)), size=1.5,aspect=3) #updated
g = g.map(plt.scatter, 'Release Year', 'Revenue Adjusted, USD mln', marker='.')
plt.suptitle("Revenue vs Release Year - by Release Year and Budget Buckets")
plt.savefig("Images/Revenue vs Release Year - by Release Year and Budget Buckets.png",dpi=300) #added
g.fig.subplots_adjust(top=.9)
plt.show()
```

## Analysis of Average Vote data

### Average Vote vs. Budget


```python

g = sns.FacetGrid(movies_money_df[(movies_money_df["Outlier"]==False) & (movies_money_df["Average Vote"]>0)], col="Years", col_order=year_buckets_labels, sharex=True, sharey=True, hue="Budget Tier", hue_order=list(reversed(budget_buckets_labels)), size=4.5,aspect=0.85) #updated
g = g.map(plt.scatter, 'Budget Adjusted, USD mln', 'Average Vote', edgecolor="w", marker='o')#updated
plt.suptitle("Average Vote vs. Budget - by Release Year Buckets")
g.fig.subplots_adjust(top=.85)
plt.savefig("Images/Average Vote vs Budget - by Release Year Buckets.png",dpi=300) #added
plt.show()
```

### Average Vote vs. Revenue



```python
g = sns.FacetGrid(movies_money_df[(movies_money_df["Outlier"]==False) & (movies_money_df["Average Vote"]>0)], col="Years", col_order=year_buckets_labels, sharex=True, sharey=True, hue="Budget Tier", hue_order=list(reversed(budget_buckets_labels)),size=4.5,aspect=0.85) #updated
g = g.map(plt.scatter, 'Revenue Adjusted, USD mln', 'Average Vote', edgecolor="w", marker='o')#updated
plt.suptitle("Average Vote vs. Revenue - by Release Year Buckets")
g.fig.subplots_adjust(top=.85)
plt.savefig("Images/Average Vote vs Revenue - by Release Year Buckets.png",dpi=300) #added
plt.show()
```

### Average Vote vs. Popularity of Starring Actors


```python

g = sns.FacetGrid(movies_money_df[(movies_money_df["Outlier"]==False) & (movies_money_df["Average Vote"]>0)], col="Years", col_order=year_buckets_labels, sharex=True, sharey=True, hue="Budget Tier", hue_order=list(reversed(budget_buckets_labels)),size=4.5,aspect=0.85)
g=g.map(plt.scatter, 'Starring Actors Popularity', 'Average Vote', edgecolor="w", marker='o')#updated
plt.suptitle("Average Vote vs. Starring Actor Popularity - by Release Year Buckets")
g.fig.subplots_adjust(top=.85)
plt.savefig("Images/Average Vote vs Starring actor popularity - by Release Year Buckets.png",dpi=300) #added
plt.show()
```


```python

g = sns.pairplot(movies_money_df[(movies_money_df["Outlier"]==False) & (movies_money_df["Average Vote"]>0)], x_vars="Revenue Adjusted, USD mln", y_vars="Average Vote", hue="Budget Tier", hue_order=list(reversed(budget_buckets_labels)),size=5,aspect=1.5)
plt.suptitle("Average Vote vs. Revenues")
plt.savefig("Images/Average Vote vs Revenues.png",dpi=300) #added
plt.show()
```

# Average vote - Conclusions
-On the assumption that the vote data is authenic, the higher is either of the above factots considered, less likely the movie quality is estimated low

-On the other hand, the estimate/vote does not necessarily increase with increase of any of the above considered factors

-Revenue does not indicate the quality of a movie. Movies with low revenues are estimated as high as the movies with high revenues. Same for movie budgets

# Analysis of Impact of Starring Actor Popularity Factor


```python
g = sns.pairplot(movies_money_df[(movies_money_df["Outlier"]==False) & (movies_money_df["Average Vote"]>0)], x_vars="Starring Actors Popularity", y_vars="Average Vote", hue="Budget Tier", hue_order=list(reversed(budget_buckets_labels)),size=5,aspect=1.5)
plt.suptitle("Average Vote vs. Starring Actors Popularity")
plt.savefig("Images/Average Vote vs Starring actor popularity.png",dpi=300) #added
plt.show()
```


```python
g = sns.jointplot(data=movies_money_df[(movies_money_df["Outlier"]==False) & (movies_money_df["Average Vote"]>0)], kind="kde",x="Starring Actors Popularity", y="Average Vote", size=5)
plt.suptitle("Average Vote vs. Starring Actors Popularity - Density")
g.fig.subplots_adjust(top=.95)
plt.savefig("Images/Average Vote vs Starring actor popularity - density.png",dpi=300) #added
plt.show()
```


```python
g = sns.pairplot(movies_money_df[~movies_money_df["Outlier"]], x_vars="Starring Actors Popularity", y_vars="Revenue Adjusted, USD mln", hue="Budget Tier", hue_order=list(reversed(budget_buckets_labels)),size=5,aspect=1.5)
plt.suptitle("Revenue vs. Starring Actors Popularity")
plt.savefig("Images/Revenue vs Starring actor popularity.png",dpi=300) #added
plt.show()
```


```python
g = sns.jointplot(data=movies_money_df[movies_money_df["Outlier"]==False], kind="kde",x="Starring Actors Popularity", y="Revenue Adjusted, USD mln", size=5)
plt.suptitle("Revenue vs. Starring Actors Popularity - Density")
g.fig.subplots_adjust(top=.95)
plt.savefig("Images/Revenue vs Starring actor popularity - density.png",dpi=300) #added
plt.show()
```

# Impact of Starring Actor Popularity Factor - Conclusions

- Although the popularity af starring actors has a weak impact of revenues, it is not a determining factor.

## Analysis of impact of Movie Budget on Revenue


```python
#movies_money_df.sort_values(["Release Years Bucket"],ascending=[True],inplace=True)
max_budget=movies_money_df[movies_money_df["Outlier"]==False]["Budget Adjusted, USD mln"].values.max()
g = sns.FacetGrid(movies_money_df[movies_money_df["Outlier"]==False], col="Years", col_order=year_buckets_labels, hue="Budget Tier", hue_order=list(reversed(budget_buckets_labels)), sharex=True, sharey=True, size=5,aspect=0.45) 
g = g.map(plt.scatter,  'Budget Adjusted, USD mln', 'Revenue Adjusted, USD mln',edgecolor="w",  marker='.')
plt.suptitle("Revenue vs. Budget - by Release Year buckets")
g.fig.subplots_adjust(top=.90)
plt.savefig("Images/Revenue vs Budget - by Release Year buckets.png",dpi=300) #added
plt.show()
```


```python
g = sns.pairplot(movies_money_df[~movies_money_df["Outlier"]], x_vars="Budget Adjusted, USD mln", y_vars="Revenue Adjusted, USD mln", hue="Budget Tier", hue_order=list(reversed(budget_buckets_labels)),size=5,aspect=1.5)
plt.suptitle("Revenue vs. Budget")
plt.savefig("Images/Revenue vs Budget.png",dpi=300) #added
plt.show()
```


```python
g = sns.jointplot(data=movies_money_df[movies_money_df["Outlier"]==False], kind="kde",x="Budget Adjusted, USD mln", y="Revenue Adjusted, USD mln", size=5)
plt.suptitle("Revenue vs. Budget - Density")
g.fig.subplots_adjust(top=.95)
plt.savefig("Images/Revenue vs Budget - density.png",dpi=300) #added
plt.show()
```

# Impact of Movie Budget on Revenue - conclusions

- Film revenues do have considerable linear dependency on budgets, although the variance is high.

# Actor Deep Dive - Part 2


```python
#Clean up df headers
actors.columns = ['ID', 'Title', 'Cast', 'Crew']
```


```python
#Create input option for actor name
actor_name = input ("What actor would you like to know about?")
```


```python
#Display number of movies acted in
selected_actor = actors[actors['Cast'].str.contains(actor_name)]
selected_actor = selected_actor.reset_index(drop=True)
moviecount = len(selected_actor.index)
print (str(actor_name) + " has been in " + str(moviecount) + " movies")
```


```python
#Display list of movies acted in
print (str(actor_name) + " has been in the following movies")
movies_played_in = pd.DataFrame(selected_actor["Title"])
movies_played_in
```


```python
#Create empty df
movies_played_in["Year Released"] = ""
movies_played_in["Rated"] = ""
movies_played_in["Rotten Tomato"] = ""
movies_played_in["Meta Score"] = ""
movies_played_in["Plot Sentiment"] = ""
movies_played_in["Plot"] = ""
movies_played_in["Genre"] = ""
movies_played_in.head()
```


```python
#Access the data from Omdb
print("Beginning Data Retrieval")
print("---------------------------------------------------------------")

#Loop through df
for index, row in movies_played_in.iterrows():
    movie_pull = row["Title"]
         
    
    try:
        url = "http://www.omdbapi.com/?t=%s&apikey=%s" % (movie_pull, omdb_key)
        
        #Print log of movie being processed
        print(f"Now retrieving Movie Data for: " + movie_pull)
       
        #Run requests to API
        movie_data = requests.get(url).json()
        pprint(movie_data)
        
        #Defining variables
        RT = movie_data["Ratings"][1]["Value"]
        Meta = movie_data["Metascore"]
        Year = movie_data["Year"]
        Rated = movie_data["Rated"]
        Plot = movie_data["Plot"]
        Sent = analyzer.polarity_scores(Plot)["compound"]
        Genre = movie_data["Genre"]
        
        #Add to df
        movies_played_in.set_value(index, "Rated", Rated)
        movies_played_in.set_value(index, "Year Released", Year)
        movies_played_in.set_value(index, "Rotten Tomato", RT)
        movies_played_in.set_value(index, "Meta Score", Meta)
        movies_played_in.set_value(index, "Plot", Plot)
        movies_played_in.set_value(index, "Plot Sentiment", Sent)
        movies_played_in.set_value(index, "Genre", Genre)
        
    except:
        movies_played_in.set_value(index, "Year Released", "N/A")
        movies_played_in.set_value(index, "Rated,", "N/A")
        movies_played_in.set_value(index, "Rotten Tomato", "N/A")
        movies_played_in.set_value(index, "Meta Score", "N/A")
        movies_played_in.set_value(index, "Plot Sentiment", "N/A")
        movies_played_in.set_value(index, "Plot", "N/A")
        movies_played_in.set_value(index, "Genre", "N/A")
        
#Display last movie json    
pprint(movie_data)
```


```python
#Format and display
movies_played_in.sort_values(["Year Released"], ascending=True, inplace=True)
movies_played_in = movies_played_in.reset_index(drop=True)
movies_played_in.head()
```


```python
#Replace inconsistent data
movies_played_in['Rotten Tomato'] = movies_played_in['Rotten Tomato'].str.replace('%','')
movies_played_in['Rotten Tomato'] = movies_played_in['Rotten Tomato'].str.replace('/100','')
movies_played_in['Rotten Tomato'] = movies_played_in['Rotten Tomato'].str.replace('N/A','')
movies_played_in['Meta Score'] = movies_played_in['Meta Score'].str.replace('%','')
movies_played_in['Meta Score'] = movies_played_in['Meta Score'].str.replace('NaN','')
movies_played_in['Meta Score'] = movies_played_in['Meta Score'].str.replace('/100','')
movies_played_in['Meta Score'] = movies_played_in['Meta Score'].str.replace('N/A','')
movies_played_in['Year Released'] = movies_played_in['Year Released'].str.replace('N/A','')
```


```python
#Converting string values to numerics
movies_played_in["Meta Score"] = pd.to_numeric(movies_played_in["Meta Score"])
movies_played_in['Rotten Tomato'] = pd.to_numeric(movies_played_in['Rotten Tomato'])
movies_played_in['Plot Sentiment'] = pd.to_numeric(movies_played_in['Plot Sentiment'])
movies_played_in['Year Released'] = pd.to_numeric(movies_played_in['Year Released'])
```


```python
from scipy.stats import linregress
#Set figure size
plt.figure(figsize=(10,6))

#Create Trendline
fake = movies_played_in["Rotten Tomato"]
(slope, intercept, _,_ , _) = linregress(movies_played_in["Year Released"], fake)
fit = slope * movies_played_in["Year Released"] + intercept

#Aesthetics
plt.title("Movie Release Date vs. Rotten Tomatoes Score " + "(" + time.strftime("%m/%d/%Y") + ")", fontsize=20)
plt.xlabel("Year Released", fontsize=16)
plt.xticks(rotation= 90)
plt.ylabel("Rotten Tomatoes Score", fontsize=16)

#Create scatter plots
plt.scatter(movies_played_in["Year Released"], movies_played_in["Rotten Tomato"], color= "green", edgecolor= "black",
label= "Rotten Tomatoes Score", s=140, alpha = 0.75)
plt.legend(bbox_to_anchor= (1.3, 1), title= actor_name + " Movies", fontsize= "medium")

#Display Trendline
plt.plot(movies_played_in["Year Released"], fit, "b--")

#Save plot as PNG image
plt.savefig("Images/Movie_Release_Date_vs._Rotten_Tomoatoes_Score.png", bbox_inches= "tight")

#Display scatter plots
plt.grid()
plt.show()
```


```python
#Set size of bar plots
plt.figure(figsize=(10,6))

#Create line graph
plt.plot(movies_played_in["Year Released"],movies_played_in["Plot Sentiment"], color= "Red", marker= "o", linestyle= "dashed",
linewidth= 2, markersize= 6)

#Aesthetics
plt.title("Release Date vs. Sentiment Score " + "(" + time.strftime("%m/%d/%Y") + ")", fontsize=20)
plt.xlabel("Release Date", fontsize=12)
plt.xticks(rotation= 90)
plt.ylabel("Compound Sentiment Score of Plot Summary", fontsize=12)


#Save plot as PNG image
plt.savefig("Images/Movie_Release_Date_vs._Sentiment_Score.png", bbox_inches= "tight")

#Display Output
plt.show()
```


```python
#Set size of bar plots
plt.figure(figsize=(10,6))

#Create bar plots for comparing the results of compound sentiment score for each movie plot
plt.bar(movies_played_in["Title"], movies_played_in["Plot Sentiment"], color= "lightblue", edgecolor= "black", width= 1)

#Aesthetics
plt.title("Movie Title vs. Sentiment Score " + "(" + time.strftime("%m/%d/%Y") + ")", fontsize=20)
plt.xlabel("Movie Title", fontsize=12)
plt.xticks(rotation= 90)
plt.ylabel("Sentiment Score of Plot Summary", fontsize=12)


#Save plot as PNG image
plt.savefig("Images/Movie_Title_vs._Sentiment_Score.png", bbox_inches= "tight")

#Display Output
plt.show()
```


```python
#Set size of pie chart
plt.figure(figsize=(10,6))

#Group "final" dataframe by "Rated"
rating = movies_played_in.groupby("Rated").count()
final_rating = pd.DataFrame(rating)

total_movies = rating["Title"]

#Set pie chart labels
labels = total_movies.index

#Define color and explode values for all pie chart use
colors = ["yellow", "lightgreen", "lightblue", "royalblue"]

#Create pie chart for "% of Total Fares by City Type"
plt.pie(total_movies, startangle = 100, colors = colors, labels = labels,
        autopct = "%1.1f%%", shadow = True, wedgeprops = {'linewidth': .5, 'edgecolor': 'black'})

#Save plot as PNG image
plt.savefig("Images/Percent_of_Movies_by_Rating.png", bbox_inches= "tight")

#Format display
plt.title("% of Movies by Movie Rating")
plt.axis("equal")
plt.show()
```


```python
#Export DataFrame as CSV
movies_played_in.to_csv("Output/actor_movie_info.csv")
```
