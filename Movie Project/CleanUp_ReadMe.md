

```python

import pandas as pd
import requests
import json
import matplotlib.pyplot as plt
import matplotlib.ticker as ticker # updated
import seaborn as sns
import numpy as np
```

# Extract the money and data


```python
movies = pd.read_csv("Resources/tmdb_5000_movies.csv")
movies_df = pd.DataFrame(movies)
movies_df=movies_df.rename(columns={"overview": "Overview", "vote_average":"Average Vote", "title":"Title", "revenue":"Revenue", "budget":"Budget"})
movies_df.head(3)
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
      <th>Budget</th>
      <th>genres</th>
      <th>homepage</th>
      <th>id</th>
      <th>keywords</th>
      <th>original_language</th>
      <th>original_title</th>
      <th>Overview</th>
      <th>popularity</th>
      <th>production_companies</th>
      <th>production_countries</th>
      <th>release_date</th>
      <th>Revenue</th>
      <th>runtime</th>
      <th>spoken_languages</th>
      <th>status</th>
      <th>tagline</th>
      <th>Title</th>
      <th>Average Vote</th>
      <th>vote_count</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>237000000</td>
      <td>[{"id": 28, "name": "Action"}, {"id": 12, "nam...</td>
      <td>http://www.avatarmovie.com/</td>
      <td>19995</td>
      <td>[{"id": 1463, "name": "culture clash"}, {"id":...</td>
      <td>en</td>
      <td>Avatar</td>
      <td>In the 22nd century, a paraplegic Marine is di...</td>
      <td>150.437577</td>
      <td>[{"name": "Ingenious Film Partners", "id": 289...</td>
      <td>[{"iso_3166_1": "US", "name": "United States o...</td>
      <td>2009-12-10</td>
      <td>2787965087</td>
      <td>162.0</td>
      <td>[{"iso_639_1": "en", "name": "English"}, {"iso...</td>
      <td>Released</td>
      <td>Enter the World of Pandora.</td>
      <td>Avatar</td>
      <td>7.2</td>
      <td>11800</td>
    </tr>
    <tr>
      <th>1</th>
      <td>300000000</td>
      <td>[{"id": 12, "name": "Adventure"}, {"id": 14, "...</td>
      <td>http://disney.go.com/disneypictures/pirates/</td>
      <td>285</td>
      <td>[{"id": 270, "name": "ocean"}, {"id": 726, "na...</td>
      <td>en</td>
      <td>Pirates of the Caribbean: At World's End</td>
      <td>Captain Barbossa, long believed to be dead, ha...</td>
      <td>139.082615</td>
      <td>[{"name": "Walt Disney Pictures", "id": 2}, {"...</td>
      <td>[{"iso_3166_1": "US", "name": "United States o...</td>
      <td>2007-05-19</td>
      <td>961000000</td>
      <td>169.0</td>
      <td>[{"iso_639_1": "en", "name": "English"}]</td>
      <td>Released</td>
      <td>At the end of the world, the adventure begins.</td>
      <td>Pirates of the Caribbean: At World's End</td>
      <td>6.9</td>
      <td>4500</td>
    </tr>
    <tr>
      <th>2</th>
      <td>245000000</td>
      <td>[{"id": 28, "name": "Action"}, {"id": 12, "nam...</td>
      <td>http://www.sonypictures.com/movies/spectre/</td>
      <td>206647</td>
      <td>[{"id": 470, "name": "spy"}, {"id": 818, "name...</td>
      <td>en</td>
      <td>Spectre</td>
      <td>A cryptic message from Bond’s past sends him o...</td>
      <td>107.376788</td>
      <td>[{"name": "Columbia Pictures", "id": 5}, {"nam...</td>
      <td>[{"iso_3166_1": "GB", "name": "United Kingdom"...</td>
      <td>2015-10-26</td>
      <td>880674609</td>
      <td>148.0</td>
      <td>[{"iso_639_1": "fr", "name": "Fran\u00e7ais"},...</td>
      <td>Released</td>
      <td>A Plan No One Escapes</td>
      <td>Spectre</td>
      <td>6.3</td>
      <td>4466</td>
    </tr>
  </tbody>
</table>
</div>



# movies_df.describe()


```python
movies_df.describe()
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
      <th>Budget</th>
      <th>id</th>
      <th>popularity</th>
      <th>Revenue</th>
      <th>runtime</th>
      <th>Average Vote</th>
      <th>vote_count</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>count</th>
      <td>4.803000e+03</td>
      <td>4803.000000</td>
      <td>4803.000000</td>
      <td>4.803000e+03</td>
      <td>4801.000000</td>
      <td>4803.000000</td>
      <td>4803.000000</td>
    </tr>
    <tr>
      <th>mean</th>
      <td>2.904504e+07</td>
      <td>57165.484281</td>
      <td>21.492301</td>
      <td>8.226064e+07</td>
      <td>106.875859</td>
      <td>6.092172</td>
      <td>690.217989</td>
    </tr>
    <tr>
      <th>std</th>
      <td>4.072239e+07</td>
      <td>88694.614033</td>
      <td>31.816650</td>
      <td>1.628571e+08</td>
      <td>22.611935</td>
      <td>1.194612</td>
      <td>1234.585891</td>
    </tr>
    <tr>
      <th>min</th>
      <td>0.000000e+00</td>
      <td>5.000000</td>
      <td>0.000000</td>
      <td>0.000000e+00</td>
      <td>0.000000</td>
      <td>0.000000</td>
      <td>0.000000</td>
    </tr>
    <tr>
      <th>25%</th>
      <td>7.900000e+05</td>
      <td>9014.500000</td>
      <td>4.668070</td>
      <td>0.000000e+00</td>
      <td>94.000000</td>
      <td>5.600000</td>
      <td>54.000000</td>
    </tr>
    <tr>
      <th>50%</th>
      <td>1.500000e+07</td>
      <td>14629.000000</td>
      <td>12.921594</td>
      <td>1.917000e+07</td>
      <td>103.000000</td>
      <td>6.200000</td>
      <td>235.000000</td>
    </tr>
    <tr>
      <th>75%</th>
      <td>4.000000e+07</td>
      <td>58610.500000</td>
      <td>28.313505</td>
      <td>9.291719e+07</td>
      <td>118.000000</td>
      <td>6.800000</td>
      <td>737.000000</td>
    </tr>
    <tr>
      <th>max</th>
      <td>3.800000e+08</td>
      <td>459488.000000</td>
      <td>875.581305</td>
      <td>2.787965e+09</td>
      <td>338.000000</td>
      <td>10.000000</td>
      <td>13752.000000</td>
    </tr>
  </tbody>
</table>
</div>




```python
movies_df.isnull().any()
```




    Budget                  False
    genres                  False
    homepage                 True
    id                      False
    keywords                False
    original_language       False
    original_title          False
    Overview                 True
    popularity              False
    production_companies    False
    production_countries    False
    release_date             True
    Revenue                 False
    runtime                  True
    spoken_languages        False
    status                  False
    tagline                  True
    Title                   False
    Average Vote            False
    vote_count              False
    dtype: bool




```python
movies_df.nunique()
```




    Budget                   436
    genres                  1175
    homepage                1691
    id                      4803
    keywords                4222
    original_language         37
    original_title          4801
    Overview                4800
    popularity              4802
    production_companies    3697
    production_countries     469
    release_date            3280
    Revenue                 3297
    runtime                  156
    spoken_languages         544
    status                     3
    tagline                 3944
    Title                   4800
    Average Vote              71
    vote_count              1609
    dtype: int64




```python
movies_df["status"].value_counts()
```




    Released           4795
    Rumored               5
    Post Production       3
    Name: status, dtype: int64




```python
sum(pd.isnull(movies_df['release_date']))
```




    1




```python
movies_df.dropna(subset=["release_date"],inplace=True)
```


```python
movies_df.loc[(movies_df["Revenue"]<=0) | (movies_df["Budget"]<=0)].count()
```




    Budget                  1573
    genres                  1573
    homepage                 365
    id                      1573
    keywords                1573
    original_language       1573
    original_title          1573
    Overview                1570
    popularity              1573
    production_companies    1573
    production_countries    1573
    release_date            1573
    Revenue                 1573
    runtime                 1571
    spoken_languages        1573
    status                  1573
    tagline                  975
    Title                   1573
    Average Vote            1573
    vote_count              1573
    dtype: int64




```python
movies_df.loc[(movies_df["Average Vote"]==0)].count()
```




    Budget                  62
    genres                  62
    homepage                13
    id                      62
    keywords                62
    original_language       62
    original_title          62
    Overview                61
    popularity              62
    production_companies    62
    production_countries    62
    release_date            62
    Revenue                 62
    runtime                 61
    spoken_languages        62
    status                  62
    tagline                 15
    Title                   62
    Average Vote            62
    vote_count              62
    dtype: int64



# Movie data analysis results

- Out of c4,803 records in the source data c1,574 have zero value for Budget and/or Revenue - removed.
- 1 record had Null release date - removed.
- 8 Records in status Rumored(c5) and Post Production(c3) removed.
- Average Vote is 0 for 62 records - to be taken into account

# Create Clean Dataset


```python
movies_money_df=movies_df.loc[(movies_df["status"]=="Released") & (movies_df["Revenue"]>0) & (movies_df["Budget"]>0),["Budget","Revenue","Title","Average Vote","release_date"]]
```


```python
movies_money_df.isnull().any()
```




    Budget          False
    Revenue         False
    Title           False
    Average Vote    False
    release_date    False
    dtype: bool




```python
movies_money_df.describe()
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
      <th>Budget</th>
      <th>Revenue</th>
      <th>Average Vote</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>count</th>
      <td>3.228000e+03</td>
      <td>3.228000e+03</td>
      <td>3228.000000</td>
    </tr>
    <tr>
      <th>mean</th>
      <td>4.066642e+07</td>
      <td>1.212803e+08</td>
      <td>6.309665</td>
    </tr>
    <tr>
      <th>std</th>
      <td>4.439840e+07</td>
      <td>1.863197e+08</td>
      <td>0.873846</td>
    </tr>
    <tr>
      <th>min</th>
      <td>1.000000e+00</td>
      <td>5.000000e+00</td>
      <td>0.000000</td>
    </tr>
    <tr>
      <th>25%</th>
      <td>1.050000e+07</td>
      <td>1.700000e+07</td>
      <td>5.800000</td>
    </tr>
    <tr>
      <th>50%</th>
      <td>2.500000e+07</td>
      <td>5.519150e+07</td>
      <td>6.300000</td>
    </tr>
    <tr>
      <th>75%</th>
      <td>5.500000e+07</td>
      <td>1.463434e+08</td>
      <td>6.900000</td>
    </tr>
    <tr>
      <th>max</th>
      <td>3.800000e+08</td>
      <td>2.787965e+09</td>
      <td>8.500000</td>
    </tr>
  </tbody>
</table>
</div>


