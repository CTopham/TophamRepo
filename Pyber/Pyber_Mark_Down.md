

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

```


```python
#Converting type to integer
merge_df['type'] = merge_df['type'].astype(int)
merge_df['type'].unique()
```




    array([2, 1, 3], dtype=int64)




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


![png](output_8_0.png)



```python
#Breaking down by city types
#--------------------------
#urban Breakdown
urbangroup = merge_df.loc[merge_df['type'] == 1,:]
urbangroup = urbangroup.sort_values("city")
urbangroup = urbangroup.reset_index(drop=True)
urbangroup.head()
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
      <td>Alexisfort</td>
      <td>2017-01-02 20:59:13</td>
      <td>34.34</td>
      <td>8805663343516</td>
      <td>24</td>
      <td>1</td>
    </tr>
    <tr>
      <th>1</th>
      <td>Alexisfort</td>
      <td>2017-01-01 23:04:18</td>
      <td>12.96</td>
      <td>2646410316386</td>
      <td>24</td>
      <td>1</td>
    </tr>
    <tr>
      <th>2</th>
      <td>Alexisfort</td>
      <td>2017-01-01 08:35:47</td>
      <td>5.75</td>
      <td>689677502842</td>
      <td>24</td>
      <td>1</td>
    </tr>
    <tr>
      <th>3</th>
      <td>Alexisfort</td>
      <td>2017-01-01 05:29:25</td>
      <td>40.10</td>
      <td>9106736762371</td>
      <td>24</td>
      <td>1</td>
    </tr>
    <tr>
      <th>4</th>
      <td>Brianfurt</td>
      <td>2017-01-03 00:54:46</td>
      <td>31.68</td>
      <td>4930297982122</td>
      <td>4</td>
      <td>1</td>
    </tr>
  </tbody>
</table>
</div>




```python
#suburban Breakdown
suburbangroup = merge_df.loc[merge_df['type'] == 2,:]
suburbangroup = suburbangroup.sort_values("city")
suburbangroup = suburbangroup.reset_index(drop=True)
suburbangroup.head()
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
      <td>2017-01-01 23:25:56</td>
      <td>35.95</td>
      <td>8549491628017</td>
      <td>27</td>
      <td>2</td>
    </tr>
    <tr>
      <th>1</th>
      <td>Amberberg</td>
      <td>2017-01-01 00:10:50</td>
      <td>18.35</td>
      <td>2979038106825</td>
      <td>13</td>
      <td>2</td>
    </tr>
    <tr>
      <th>2</th>
      <td>Amberberg</td>
      <td>2017-01-02 08:39:01</td>
      <td>18.29</td>
      <td>5521911046390</td>
      <td>13</td>
      <td>2</td>
    </tr>
    <tr>
      <th>3</th>
      <td>Anthonyfurt</td>
      <td>2017-01-02 06:10:52</td>
      <td>23.58</td>
      <td>8340450977241</td>
      <td>17</td>
      <td>2</td>
    </tr>
    <tr>
      <th>4</th>
      <td>Anthonyfurt</td>
      <td>2017-01-02 18:04:58</td>
      <td>41.22</td>
      <td>2152069612682</td>
      <td>17</td>
      <td>2</td>
    </tr>
  </tbody>
</table>
</div>




```python
#Rural Breakdown
ruralgroup = merge_df.loc[merge_df['type'] == 3,:]
ruralgroup = ruralgroup.sort_values("city")
ruralgroup = ruralgroup.reset_index(drop=True)
ruralgroup.head()
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
      <td>Davidsonfurt</td>
      <td>2017-01-02 09:47:09</td>
      <td>16.36</td>
      <td>6392658180499</td>
      <td>1</td>
      <td>3</td>
    </tr>
    <tr>
      <th>1</th>
      <td>Hoganfort</td>
      <td>2017-01-03 12:15:48</td>
      <td>19.35</td>
      <td>685572928589</td>
      <td>5</td>
      <td>3</td>
    </tr>
    <tr>
      <th>2</th>
      <td>Nguyenshire</td>
      <td>2017-01-01 09:32:08</td>
      <td>17.88</td>
      <td>6501330258436</td>
      <td>3</td>
      <td>3</td>
    </tr>
    <tr>
      <th>3</th>
      <td>Port Jameston</td>
      <td>2017-01-01 15:47:28</td>
      <td>45.63</td>
      <td>7714482032277</td>
      <td>2</td>
      <td>3</td>
    </tr>
    <tr>
      <th>4</th>
      <td>Richardsonborough</td>
      <td>2017-01-03 05:36:06</td>
      <td>34.64</td>
      <td>1523382445416</td>
      <td>9</td>
      <td>3</td>
    </tr>
  </tbody>
</table>
</div>




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


![png](output_15_0.png)



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
#grouping by type
pie_df = piemerge_df.groupby(['type'], as_index=False).sum()[['type','fare','driver_count']]
pie_df.head()
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
      <th>type</th>
      <th>fare</th>
      <th>driver_count</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>Rural</td>
      <td>4271.69</td>
      <td>662</td>
    </tr>
    <tr>
      <th>1</th>
      <td>Suburban</td>
      <td>18779.26</td>
      <td>8774</td>
    </tr>
    <tr>
      <th>2</th>
      <td>Urban</td>
      <td>40093.25</td>
      <td>60935</td>
    </tr>
  </tbody>
</table>
</div>




```python
#grouping by ride count to get the count instead of sum
ridecount_df = piemerge_df.groupby(['type'], as_index=False).count()[['type','ride_id']]
ridecount_df
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
      <th>type</th>
      <th>ride_id</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>Rural</td>
      <td>125</td>
    </tr>
    <tr>
      <th>1</th>
      <td>Suburban</td>
      <td>625</td>
    </tr>
    <tr>
      <th>2</th>
      <td>Urban</td>
      <td>1625</td>
    </tr>
  </tbody>
</table>
</div>




```python
#merging into one DF
finalpie_df = pd.merge(pie_df, ridecount_df, how='outer', on='type')
finalpie_df = finalpie_df.sort_values("type")
finalpie_df = finalpie_df.reset_index(drop=True)
finalpie_df.head()
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
      <th>type</th>
      <th>fare</th>
      <th>driver_count</th>
      <th>ride_id</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>Rural</td>
      <td>4271.69</td>
      <td>662</td>
      <td>125</td>
    </tr>
    <tr>
      <th>1</th>
      <td>Suburban</td>
      <td>18779.26</td>
      <td>8774</td>
      <td>625</td>
    </tr>
    <tr>
      <th>2</th>
      <td>Urban</td>
      <td>40093.25</td>
      <td>60935</td>
      <td>1625</td>
    </tr>
  </tbody>
</table>
</div>




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




    <function matplotlib.pyplot.show>




![png](output_21_1.png)



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




    <function matplotlib.pyplot.show>




![png](output_22_1.png)



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




    <function matplotlib.pyplot.show>




![png](output_23_1.png)

