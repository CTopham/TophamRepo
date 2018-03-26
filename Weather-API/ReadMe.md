

```python
#Python weather API project
#-------Scatters-------------
#Temperature (F) vs. Latitude
#Humidity (%) vs. Latitude
#Cloudiness (%) vs. Latitude
#Wind Speed (mph) vs. Latitude

from citipy import citipy
import openweathermapy.core as owm
import decimal
import requests
import json
import numpy as np
import pandas as pd
from configapi import gkey
import matplotlib.pyplot as plt
import random
from random import shuffle
```


```python
#Generating random numbers for longitude
long = []
while len(long) < 600:
    long.append(random.randint(-1800000, 1800000)/10000)
    shuffle(long)
```


```python
#Generating random numbers for lattitude (staying under 80's for major cities)
lat = []
while len(lat) < 600:
    lat.append(random.randint(-800000, 800000)/10000)
    shuffle(lat)
```


```python
#Creating initial DF with my longitude and latitude
weather = pd.DataFrame({"Latitude": lat, "Longitude": long})
weather.head()
```


```python
#Building columns in my DF to place data
weather["City"] = ""
weather["Country"] = ""
weather["Temperature"] = ""
weather["Cloudiness"] = ""
weather["Wind Speed"] = ""
weather["Humidity"] = ""
weather["City ID"] = ""
weather["URL"] = ""
weather = weather [["City","Country", "Temperature", "Cloudiness", "Wind Speed", "Humidity","Latitude","Longitude","City ID", "URL"]]
weather.head()
```


```python
# Using the Citipy library to pull in cities using the random longitude and lattitude numbers obtained above
#Placing the cities in the Dataframe

for index, row in weather.iterrows():
    latitude = row['Latitude']
    longitude = row ["Longitude"]
    
    weather.set_value(index, "City", citipy.nearest_city(latitude, longitude).city_name)
    weather.set_value(index, "Country", citipy.nearest_city(latitude, longitude).country_code)
    
weather.head()
```


```python
#--------------------------------------------------------------------------
# Starting API calls
#--------------------------------------------------------------------------
# Using Imperial metrics to grab Fahrenheit
#URL Structure obtained here: https://openweathermap.org/current#data
url = "http://api.openweathermap.org/data/2.5/weather?units=Imperial"
```


```python
#Testing an API pull, looking at the JSON
print (url + "&appid=" + gkey + "&q=" + "Las Vegas")
```


```python
#Looping through the DF: grabbing url, api key, and city. 
#Building the url 
#pulling it in json format
for index, row in weather.iterrows():
    city = row['City']
    
    try:
        url_build = url + "&appid=" + gkey + "&q=" + city
        weather_info = requests.get(url_build).json()
        
#Placing in DF       

        weather.set_value(index, "Temperature", weather_info['main']['temp'])
        weather.set_value(index, "Humidity", weather_info['main']['humidity'])
        weather.set_value(index, "Cloudiness", weather_info['clouds']['all'])
        weather.set_value(index, "Wind Speed", weather_info['wind']['speed'])
        weather.set_value(index, "City ID", weather_info['id'])
        weather.set_value(index, "URL", url_build)
        print(f"{city},{weather_info['id']}")


#If it does not work then place "NaN" in location
    except:
        weather.set_value(index, "Temperature", "No Data from API")
        weather.set_value(index, "Humidity", "No Data from API")
        weather.set_value(index, "Cloudiness", "No Data from API")
        weather.set_value(index, "Wind Speed", "No Data from API")
        weather.set_value(index, "City ID", "No Data from API")
        weather.set_value(index, "URL", "No Data from API")
        
        print("NaN")
```


```python
weather.head()
```


```python
#Removing the the "no data" returns
weather_cleaned = weather[weather["URL"]!="No Data from API"]
weather_cleaned.count()
```


```python
#Creating scatter charts
import seaborn as sns
sns.set_style("whitegrid")
fig, (ax1, ax2, ax3, ax4) = plt.subplots(4, sharex=True,figsize=(15,15))

fig.suptitle("Weather Around the World", fontsize=16, fontweight="bold")

#Temp vs Latitude
ax1.set_xlim(-80, 80)
ax1.set_ylim(-50, 120)
ax1.set_xlabel("Latitude")
ax1.set_ylabel("Temperature")
ax1.axvline(x=0)
ax1.plot(weather_cleaned["Latitude"], weather_cleaned["Temperature"], linewidth=0, marker='o')


#Humidity vs Latitude
ax2.set_xlim(-80, 80)
ax2.set_ylim(0, 105)
ax2.set_xlabel("Latitude")
ax2.set_ylabel("Humidity")
ax2.axvline(x=0)
ax2.plot(weather_cleaned["Latitude"], weather_cleaned["Humidity"], linewidth=0, marker='o', color ="green")


#Coudiness vs Latitude
ax3.set_xlim(-80, 80)
ax3.set_ylim(0, 110)
ax3.set_xlabel("Latitude")
ax3.set_ylabel("Cloudiness")
ax3.axvline(x=0)
ax3.plot(weather_cleaned["Latitude"], weather_cleaned["Cloudiness"], linewidth=0, marker='o', color ="grey")


#Wind Speed vs Latitude
ax4.set_xlim(-80, 80)
ax4.set_ylim(0, 100)
ax4.set_xlabel("Latitude")
ax4.set_ylabel("Wind Speed")
ax4.plot(weather_cleaned["Latitude"], weather_cleaned["Wind Speed"], linewidth=0, marker='o', color ="chartreuse")
ax4.axvline(x=0)


plt.show()
```
