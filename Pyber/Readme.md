

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

```


```python
#Converting type to integer
merge_df['type'] = merge_df['type'].astype(int)
merge_df['type'].unique()
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
#Breaking down by city types
#--------------------------
#urban Breakdown
urbangroup = merge_df.loc[merge_df['type'] == 1,:]
urbangroup = urbangroup.sort_values("city")
urbangroup = urbangroup.reset_index(drop=True)
urbangroup.head()
```


```python
#suburban Breakdown
suburbangroup = merge_df.loc[merge_df['type'] == 2,:]
suburbangroup = suburbangroup.sort_values("city")
suburbangroup = suburbangroup.reset_index(drop=True)
suburbangroup.head()
```


```python
#Rural Breakdown
ruralgroup = merge_df.loc[merge_df['type'] == 3,:]
ruralgroup = ruralgroup.sort_values("city")
ruralgroup = ruralgroup.reset_index(drop=True)
ruralgroup.head()
```


```python
#Taking the above merges on types and grouping them by data required on the bubble chart then placing them in variables for plotting
#----------------------------------------------------------
#Urban Fair per city breakdown
ufares = urbangroup.groupby(['city'], as_index=False).mean()[['city','fare','driver_count']]
#groupin by ride since its a count
urides = urbangroup.groupby(['city'], as_index=False).count()[['ride_id',]]
urides['ride count'] = urides['ride_id']
del urides['ride_id']
#urban x y s c setup
x = ufares['driver_count']
y = ufares['fare']
s = urides['ride count']
```


```python
#suburban Fair per city breakdown
sfares = suburbangroup.groupby(['city'], as_index=False).mean()[['city','fare','driver_count']]
#groupin by ride since its a count
srides = suburbangroup.groupby(['city'], as_index=False).count()[['ride_id',]]
srides['ride count'] = srides['ride_id']
del srides['ride_id']
#suburban x y s c setup
sx = sfares['driver_count']
sy = sfares['fare']
ss = srides['ride count']
```


```python
#rural Fair per city breakdown
rfares = ruralgroup.groupby(['city'], as_index=False).mean()[['city','fare','driver_count']]
#groupin by ride since its a count
rrides = ruralgroup.groupby(['city'], as_index=False).count()[['ride_id',]]
rrides['ride count'] = rrides['ride_id']
del rrides['ride_id']
#rural x y s c setup
rx = rfares['driver_count']
ry = rfares['fare']
rs = rrides['ride count']
```


```python
#Explanation

#Each bubble is a city.
# X axis is the average amount of drivers per city.
# Y is the Average Fares per city.
# C  is the bubble area: sum of rides in a city.
# Z is the color of the bubble - 

plt.title("Car Sharing")
plt.xlabel('Drivers per city')
plt.ylabel('Fare')
plt.scatter(x, y, s=s*200, c='lightcoral', alpha=0.5, edgecolors="grey", linewidth=1,)
plt.scatter(sx, sy, s=ss*200, c='gold', alpha=0.5, edgecolors="grey", linewidth=1,)
plt.scatter(rx, ry, s=rs*200, c='lightskyblue', alpha=0.5, edgecolors="grey", linewidth=1,)
Urban = mpatches.Patch(color='lightcoral', label='Urban')
Suburban = mpatches.Patch(color='gold', label='Suburban')
Rural = mpatches.Patch(color='lightskyblue', label='Rural')
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
finalpie_df = pd.merge(pie_df, ridecount_df, how='outer', on='type')
finalpie_df = finalpie_df.sort_values("type")
finalpie_df = finalpie_df.reset_index(drop=True)
finalpie_df.head()
```


```python
#Total fares by city type
colors = ['Gold', 'LightSkyBlue','LightCoral']
explode = (0, 0, 0.05)
plt.pie(finalpie_df['fare'],labels=finalpie_df['type'],explode=explode, colors=colors,
        autopct="%1.1f%%", shadow=True, startangle=40)
plt.axis("equal")
plt.savefig("Fares.png")
plt.show
```


```python
#Total rides by city type
colors = ['Gold', 'LightSkyBlue','LightCoral']
explode = (0, 0, 0.05)
plt.pie(finalpie_df['ride_id'],labels=finalpie_df['type'],explode=explode, colors=colors,
        autopct="%1.1f%%", shadow=True, startangle=40)
plt.axis("equal")
plt.savefig("Rides.png")
plt.show
```


```python
#Total drivers by city type
colors = ['Gold', 'LightSkyBlue','LightCoral']
explode = (0.0,0.0, 0.05)
plt.pie(finalpie_df['driver_count'],labels=finalpie_df['type'],explode=explode, colors=colors,
        autopct="%1.1f%%", shadow=True, startangle=40)
plt.axis("equal")
plt.savefig("Drivers.png")
plt.show
```
