

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




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>city</th>
      <th>driver_count</th>
      <th>type</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>Tammyburgh</td>
      <td>11</td>
      <td>Urban</td>
    </tr>
    <tr>
      <th>1</th>
      <td>Melissaborough</td>
      <td>15</td>
      <td>Urban</td>
    </tr>
    <tr>
      <th>2</th>
      <td>Port Brianborough</td>
      <td>62</td>
      <td>Urban</td>
    </tr>
    <tr>
      <th>3</th>
      <td>New Katherine</td>
      <td>68</td>
      <td>Urban</td>
    </tr>
    <tr>
      <th>4</th>
      <td>Lake Charlesside</td>
      <td>65</td>
      <td>Urban</td>
    </tr>
  </tbody>
</table>
</div>




```python
city_df = city_df.sort_values("driver_count",ascending=True)
city_df.head()
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>city</th>
      <th>driver_count</th>
      <th>type</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>122</th>
      <td>Sheltonhaven</td>
      <td>1</td>
      <td>Rural</td>
    </tr>
    <tr>
      <th>69</th>
      <td>Robertsonhaven</td>
      <td>1</td>
      <td>Suburban</td>
    </tr>
    <tr>
      <th>101</th>
      <td>Kaylaton</td>
      <td>1</td>
      <td>Suburban</td>
    </tr>
    <tr>
      <th>118</th>
      <td>Davidsonfurt</td>
      <td>1</td>
      <td>Rural</td>
    </tr>
    <tr>
      <th>110</th>
      <td>Joshuaview</td>
      <td>1</td>
      <td>Rural</td>
    </tr>
  </tbody>
</table>
</div>




```python
#Merging on 'city
merge_df = pd.merge(ride_df, city_df, how='outer', on='city')
merge_df = merge_df.sort_values("city")
merge_df = merge_df.reset_index(drop=True)
merge_df.head()
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>city</th>
      <th>date</th>
      <th>fare</th>
      <th>ride_id</th>
      <th>driver_count</th>
      <th>type</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>Adamschester</td>
      <td>2017-01-01 13:43:33</td>
      <td>48.33</td>
      <td>5433192651081</td>
      <td>27</td>
      <td>Suburban</td>
    </tr>
    <tr>
      <th>1</th>
      <td>Adamschester</td>
      <td>2017-01-02 16:19:03</td>
      <td>31.09</td>
      <td>7079690106388</td>
      <td>27</td>
      <td>Suburban</td>
    </tr>
    <tr>
      <th>2</th>
      <td>Adamschester</td>
      <td>2017-01-01 04:06:31</td>
      <td>12.97</td>
      <td>1970667817299</td>
      <td>27</td>
      <td>Suburban</td>
    </tr>
    <tr>
      <th>3</th>
      <td>Adamschester</td>
      <td>2017-01-03 06:15:43</td>
      <td>39.39</td>
      <td>8562770005118</td>
      <td>27</td>
      <td>Suburban</td>
    </tr>
    <tr>
      <th>4</th>
      <td>Adamschester</td>
      <td>2017-01-01 16:49:22</td>
      <td>14.17</td>
      <td>6979569807501</td>
      <td>27</td>
      <td>Suburban</td>
    </tr>
  </tbody>
</table>
</div>




```python
#Numerating the City Types so they can correspond with bubble color
merge_df['type'] = merge_df['type'].str.replace('Urban','1')
merge_df['type'] = merge_df['type'].str.replace('Suburban','2')
merge_df['type'] = merge_df['type'].str.replace('Rural','3')

city_df.dtypes
```




    city            object
    driver_count     int64
    type            object
    dtype: object




```python
#Converting type to integer
merge_df['type'] = merge_df['type'].astype(int)
merge_df['type'].dtypes
```




    dtype('int32')




```python
#Sampling the data to create space on the plot
merge_df = merge_df.sample(frac=0.1)
merge_df.count()
```




    city            238
    date            238
    fare            238
    ride_id         238
    driver_count    238
    type            238
    dtype: int64




```python
#Fair per city breakdown
fare_per_city = merge_df.groupby(['city'], as_index=False).mean()[['city','fare']]
fare_per_city.count()
```




    city    102
    fare    102
    dtype: int64




```python
#grouping by city and ride, converting to df, renaming column and deleting old column
ride_per_city = merge_df.groupby(['city'], as_index=False).count()[['city','ride_id']]
ride_per_city['ride count'] = ride_per_city['ride_id']
del ride_per_city['ride_id']
ride_per_city.count()
```




    city          102
    ride count    102
    dtype: int64




```python
#grouping by city type
city_type = merge_df.groupby(['city'], as_index=False).mean()[['city','type']]
city_type.count()
```




    city    102
    type    102
    dtype: int64




```python
#Grabbing drivers per city
drivers_per_city = merge_df.groupby(['city'], as_index=False).mean()[['city','driver_count']]
drivers_per_city.count()
```




    city            102
    driver_count    102
    dtype: int64




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
