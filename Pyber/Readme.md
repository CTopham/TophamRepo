

```python
#---Bubble Chart---
#Average Fare ($) Per City
#Total Number of Rides Per City
#Total Number of Drivers Per City
#City Type (Urban, Suburban, Rural)

#----Pie Chart-----
#% of Total Fares by City Type
#% of Total Rides by City Type
#% of Total Drivers by City Type

#Dependencies
import pandas as pd
import numpy as np
from matplotlib import pyplot as plt
import seaborn as sns
import matplotlib.colors
from pylab import *
from scipy import *
import matplotlib.patches as mpatches
```


```python
#Pulling in the data
city_path = "generated_data/city_data.csv"
ride_path = "generated_data/ride_data.csv"
#Reading data
city_df = pd.read_csv(city_path, encoding="utf-8")
ride_df = pd.read_csv(ride_path, encoding="utf-8")
```


```python
#Looking at DF
city_df.head()
```


```python
city_df = city_df.sort_values("driver_count",ascending=True)
city_df.head()
```


```python
#Merging on 'city
merge_df = pd.merge(ride_df, city_df, how='outer', on='city')
merge_df = merge_df.sort_values("city")
merge_df = merge_df.reset_index(drop=True)
merge_df.head()
```


```python
#Numerating the City Types so they can correspond with bubble color
merge_df['type'] = merge_df['type'].str.replace('Urban','1')
merge_df['type'] = merge_df['type'].str.replace('Suburban','2')
merge_df['type'] = merge_df['type'].str.replace('Rural','3')

city_df.dtypes
```


```python
#Converting type to integer
merge_df['type'] = merge_df['type'].astype(int)
merge_df['type'].dtypes
```


```python
#Sampling the data to create space on the plot
merge_df = merge_df.sample(frac=0.1)
merge_df.count()
```


```python
#Looping to grab some random samples in the Fares column
div = 20
lim = len(merge_df) // div
samples = [merge_df.iloc[(i * div):(i * div + div), 2]
           for i in range(0, lim)]
```


```python
# Checking Standard Error Measurements
means = [s.mean() for s in samples]
sem = [s.sem() for s in samples]
fig, ax = plt.subplots()
ax.errorbar(np.arange(0, len(means)), means, yerr=sem, fmt="o", color="b",
            alpha=0.5, label="Mean of Fares")

ax.set_xlim(-0.5, len(means))
ax.set_xlabel("Sample Number")
ax.set_ylabel("Mean of Fares")

plt.legend(loc="best", fontsize="small", fancybox=True)
plt.show()
```


```python
#Fair per city breakdown
fare_per_city = merge_df.groupby(['city'], as_index=False).mean()[['city','fare']]
fare_per_city.count()
```


```python
#grouping by city and ride, converting to df, renaming column and deleting old column
ride_per_city = merge_df.groupby(['city'], as_index=False).count()[['city','ride_id']]
ride_per_city['ride count'] = ride_per_city['ride_id']
del ride_per_city['ride_id']
ride_per_city.count()
```


```python
#grouping by city type
city_type = merge_df.groupby(['city'], as_index=False).mean()[['city','type']]
city_type.count()
```


```python
#Grabbing drivers per city
drivers_per_city = merge_df.groupby(['city'], as_index=False).mean()[['city','driver_count']]
drivers_per_city.count()
```


```python
x = drivers_per_city['driver_count']

```


```python
y = fare_per_city['fare']

```


```python
s = ride_per_city['ride count']

```


```python
c = city_type['type']

```


```python
#Explanation

#Each bubble is a city.
# X axis is the average amount of drivers per city.
# Y is the Average Fares per city.
# C  is the bubble area: sum of rides in a city.
# Z is the color of the bubble - the darker the color the more rural the city.

plt.title("Car Sharing")
plt.xlabel('Drivers per city')
plt.ylabel('Fare')
plt.scatter(x, y, s=s*200, c=c, cmap="Blues", alpha=0.5, edgecolors="grey", linewidth=1,)
figsize=(100,100)
Urban = mpatches.Patch(color='white', label='Urban')
Suburban = mpatches.Patch(color='dodgerblue', label='Suburban')
Rural = mpatches.Patch(color='blue', label='Rural')
plt.legend(handles=[Urban,Suburban,Rural], loc=1)
plt.show()
```


```python
#Take away
#1) Rural areas have higher fairs on average, most likely traveling further
#2) Cities with lowers fairs take more rides
#3) Urban areas have more drivers in the city

```


```python
#Merge 2 for pie charts
piemerge_df = pd.merge(ride_df, city_df, how='outer', on='city')
piemerge_df = piemerge_df.sort_values("city")
piemerge_df = piemerge_df.reset_index(drop=True)
piemerge_df.head()
```


```python
#grouping by type
pie_df = piemerge_df.groupby(['type'], as_index=False).sum()[['type','fare','driver_count']]
pie_df.head()
```


```python
#grouping by ride count to get the count instead of sum
ridecount_df = piemerge_df.groupby(['type'], as_index=False).count()[['type','ride_id']]
ridecount_df
```


```python
#merging into one DF
piemerge_df = pd.merge(pie_df, ridecount_df, how='outer', on='type')
piemerge_df = piemerge_df.sort_values("type")
piemerge_df = piemerge_df.reset_index(drop=True)
piemerge_df.head()
```


```python
#Total fares by city type
colors = ['Gold', 'LightSkyBlue','LightCoral']
explode = (0, 0, 0.05)
plt.pie(piemerge_df['fare'],labels=piemerge_df['type'],explode=explode, colors=colors,
        autopct="%1.1f%%", shadow=True, startangle=40)
plt.axis("equal")
plt.show
```


```python
#Total rides by city type
colors = ['Gold', 'LightSkyBlue','LightCoral']
explode = (0, 0, 0.05)
plt.pie(piemerge_df['ride_id'],labels=piemerge_df['type'],explode=explode, colors=colors,
        autopct="%1.1f%%", shadow=True, startangle=40)
plt.axis("equal")
plt.show
```


```python
#Total drivers by city type
colors = ['Gold', 'LightSkyBlue','LightCoral']
explode = (0.1, 0.09, 0.09)
plt.pie(piemerge_df['driver_count'],labels=piemerge_df['type'],explode=explode, colors=colors,
        autopct="%1.1f%%", shadow=True, startangle=40)
plt.axis("equal")
plt.show
```
