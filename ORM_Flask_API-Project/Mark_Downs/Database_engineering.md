

```python
!rm Hawaii.sqlite
```


```python
#Normal Analytics Dependencies
import matplotlib
import pandas as pd
import numpy as np
matplotlib.use('nbagg')
import matplotlib.pyplot as plt
from matplotlib import style
import datetime as dt
from sqlalchemy.orm import Session
style.use('seaborn')

#ORM Dependencies
import sqlalchemy
from sqlalchemy import create_engine, MetaData
from sqlalchemy import create_engine, Column, Integer, String, Float, inspect, MetaData
from sqlalchemy.ext.declarative import declarative_base

# Declaritive base for table schema creation
Base = declarative_base()
```


```python
# Bringing in the cleaned CSV's
Measurements_path = "Output/Clean_Measurement.csv"
Stations_path = "Output/Clean_Station.csv"
#Reading data
Measurement_df = pd.read_csv(Measurements_path, encoding="utf-8")
Station_df = pd.read_csv(Stations_path, encoding="utf-8")
```


```python
#Viewing Measurement DF
Measurement_df.head()
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
      <th>M_ID</th>
      <th>station</th>
      <th>date</th>
      <th>prcp</th>
      <th>tobs</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>1</td>
      <td>USC00519397</td>
      <td>2010-01-01</td>
      <td>0.08</td>
      <td>65</td>
    </tr>
    <tr>
      <th>1</th>
      <td>2</td>
      <td>USC00519397</td>
      <td>2010-01-02</td>
      <td>0.00</td>
      <td>63</td>
    </tr>
    <tr>
      <th>2</th>
      <td>3</td>
      <td>USC00519397</td>
      <td>2010-01-03</td>
      <td>0.00</td>
      <td>74</td>
    </tr>
    <tr>
      <th>3</th>
      <td>4</td>
      <td>USC00519397</td>
      <td>2010-01-04</td>
      <td>0.00</td>
      <td>76</td>
    </tr>
    <tr>
      <th>4</th>
      <td>5</td>
      <td>USC00519397</td>
      <td>2010-01-07</td>
      <td>0.06</td>
      <td>70</td>
    </tr>
  </tbody>
</table>
</div>




```python
#Viewing Station DF
Station_df.head()
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
      <th>S_ID</th>
      <th>station</th>
      <th>name</th>
      <th>latitude</th>
      <th>longitude</th>
      <th>elevation</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>S1</td>
      <td>USC00519397</td>
      <td>WAIKIKI 717.2, HI US</td>
      <td>21.2716</td>
      <td>-157.8168</td>
      <td>3.0</td>
    </tr>
    <tr>
      <th>1</th>
      <td>S2</td>
      <td>USC00513117</td>
      <td>KANEOHE 838.1, HI US</td>
      <td>21.4234</td>
      <td>-157.8015</td>
      <td>14.6</td>
    </tr>
    <tr>
      <th>2</th>
      <td>S3</td>
      <td>USC00514830</td>
      <td>KUALOA RANCH HEADQUARTERS 886.9, HI US</td>
      <td>21.5213</td>
      <td>-157.8374</td>
      <td>7.0</td>
    </tr>
    <tr>
      <th>3</th>
      <td>S4</td>
      <td>USC00517948</td>
      <td>PEARL CITY, HI US</td>
      <td>21.3934</td>
      <td>-157.9751</td>
      <td>11.9</td>
    </tr>
    <tr>
      <th>4</th>
      <td>S5</td>
      <td>USC00518838</td>
      <td>UPPER WAHIAWA 874.3, HI US</td>
      <td>21.4992</td>
      <td>-158.0111</td>
      <td>306.6</td>
    </tr>
  </tbody>
</table>
</div>




```python
#Creating a Database workhorse to store both of the cleaned CSV's into a relational tables
engine = create_engine("sqlite:///Hawaii.sqlite")
conn = engine.connect()
```


```python
 # Define a Measurement class
class Measurement(Base):
    __tablename__ = "Measurement"
    
    M_ID= Column(Integer, primary_key=True)
    station = Column(String)
    date = Column(String) 
    prcp = Column(Float) 
    tobs = Column(Integer)
```


```python
#Defining  a Station Class
class Station(Base):
    __tablename__ = "Station"
    S_ID= Column(String, primary_key=True)
    station = Column(String)
    name = Column(String)
    latitude = Column(Float)
    longitude = Column(Float)
    elevation = Column(Float)
    
    
```


```python
Base.metadata.create_all(engine)
session = Session(bind=engine)
#session.add(Measurement)
#session.commit()
```


```python
data_m = Measurement_df.to_dict(orient='records')
data_m[0]
```




    {'M_ID': 1,
     'date': '2010-01-01',
     'prcp': 0.08,
     'station': 'USC00519397',
     'tobs': 65}




```python
data_s = Station_df.to_dict(orient='records')
data_s[0]
```




    {'S_ID': 'S1',
     'elevation': 3.0,
     'latitude': 21.2716,
     'longitude': -157.8168,
     'name': 'WAIKIKI 717.2, HI US',
     'station': 'USC00519397'}




```python
metadata = MetaData(bind=engine)
metadata.reflect()
```


```python
Measure_Table = sqlalchemy.Table('Measurement', metadata, autoload=True)
```


```python
Station_Table = sqlalchemy.Table('Station', metadata, autoload=True)
```


```python
#conn.execute(Measure_Table.delete())
```


```python
conn.execute(Measure_Table.insert(), data_m)
```




    <sqlalchemy.engine.result.ResultProxy at 0x181901725f8>




```python
conn.execute(Station_Table.insert(), data_s)
```




    <sqlalchemy.engine.result.ResultProxy at 0x1819072f908>




```python
conn.execute("select * from Measurement limit 5").fetchall()
```




    [(1, 'USC00519397', '2010-01-01', 0.08, 65),
     (2, 'USC00519397', '2010-01-02', 0.0, 63),
     (3, 'USC00519397', '2010-01-03', 0.0, 74),
     (4, 'USC00519397', '2010-01-04', 0.0, 76),
     (5, 'USC00519397', '2010-01-07', 0.06, 70)]




```python
conn.execute("select * from Station limit 5").fetchall()
```




    [('S1', 'USC00519397', 'WAIKIKI 717.2, HI US', 21.2716, -157.8168, 3.0),
     ('S2', 'USC00513117', 'KANEOHE 838.1, HI US', 21.4234, -157.8015, 14.6),
     ('S3', 'USC00514830', 'KUALOA RANCH HEADQUARTERS 886.9, HI US', 21.5213, -157.8374, 7.0),
     ('S4', 'USC00517948', 'PEARL CITY, HI US', 21.3934, -157.9751, 11.9),
     ('S5', 'USC00518838', 'UPPER WAHIAWA 874.3, HI US', 21.4992, -158.0111, 306.6)]


