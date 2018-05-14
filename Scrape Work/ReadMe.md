

```python
#Importing dependencies
import time
from splinter import Browser
from bs4 import BeautifulSoup
from selenium import webdriver
import pandas as pd
import numpy as np

```


```python
#Executing Chrome Driver for auto navigation to click links
def init_browser():
    executable_path = {'executable_path': r'C:\Users\Craig\Desktop\chromedriver.exe'}
    return Browser("chrome", **executable_path, headless=False)
```


```python
#Looping through Nasa website and grabbing the latest title and news
browser = init_browser()
listings = {}
#Setting url to website
url = "https://mars.nasa.gov/news/?page=0&per_page=40&order=publish_date+desc%2Ccreated_at+desc&search=&category=19%2C165%2C184%2C204&blank_scope=Latest"
browser.visit(url)
time.sleep(2)
#grabbing html
html = browser.html
soup = BeautifulSoup(html, "html.parser")
#Grabbing title and paragraph text
try:
    listings["News Title"] = soup.find(class_="content_title").get_text()
    xpath = '//*[contains(@class, "list_image")]'
    results = browser.find_by_xpath(xpath)
    img = results[0]
    img.click()
    html = browser.html
    soup = BeautifulSoup(html, "html.parser")
    #opening new window with [paragraph]
    html = browser.html
    soup = BeautifulSoup(html, "html.parser")
    listings["News p"] = soup.find(class_="wysiwyg_content").get_text()
except AttributeError:
        print ("Error found")
```


```python
listings
```




    {'News Title': 'Mars Helicopter to Fly on NASA’s Next Red Planet Rover Mission',
     'News p': "\n\n\n\nNASA is sending a helicopter to Mars.\nThe Mars Helicopter, a small, autonomous rotorcraft, will travel with the agency’s Mars 2020 rover mission, currently scheduled to launch in July 2020, to demonstrate the viability and potential of heavier-than-air vehicles on the Red Planet. \n“NASA has a proud history of firsts,” said NASA Administrator Jim Bridenstine. “The idea of a helicopter flying the skies of another planet is thrilling. The Mars Helicopter holds much promise for our future science, discovery, and exploration missions to Mars.”\nU.S. Rep. John Culberson of Texas echoed Bridenstine’s appreciation of the impact of American firsts on the future of exploration and discovery.\n“It’s fitting that the United States of America is the first nation in history to fly the first heavier-than-air craft on another world,” Culberson said. “This exciting and visionary achievement will inspire young people all over the United States to become scientists and engineers, paving the way for even greater discoveries in the future.”\nStarted in August 2013 as a technology development project at NASA’s Jet Propulsion Laboratory, the Mars Helicopter had to prove that big things could come in small packages. The result of the team’s four years of design, testing and redesign weighs in at little under four pounds (1.8 kilograms). Its fuselage is about the size of a softball, and its twin, counter-rotating blades will bite into the thin Martian atmosphere at almost 3,000 rpm -- about 10 times the rate of a helicopter on Earth.\n“Exploring the Red Planet with NASA’s Mars Helicopter exemplifies a successful marriage of science and technology innovation and is a unique opportunity to advance Mars exploration for the future,” said Thomas Zurbuchen, Associate Administrator for NASA's Science Mission Directorate at the agency headquarters in Washington. “After the Wright Brothers proved 117 years ago that powered, sustained, and controlled flight was possible here on Earth, another group of American pioneers may prove the same can be done on another world.”\nThe helicopter also contains built-in capabilities needed for operation at Mars, including solar cells to charge its lithium-ion batteries, and a heating mechanism to keep it warm through the cold Martian nights. But before the helicopter can fly at Mars it has to get there. It will do so attached to the belly pan of the Mars 2020 rover.\n“The altitude record for a helicopter flying here on Earth is about 40,000 feet. The atmosphere of Mars is only one percent that of Earth, so when our helicopter is on the Martian surface, it’s already at the Earth equivalent of 100,000 feet up,” said Mimi Aung, Mars Helicopter project manager at JPL. “To make it fly at that low atmospheric density, we had to scrutinize everything, make it as light as possible while being as strong and as powerful as it can possibly be.”\nOnce the rover is on the planet’s surface, a suitable location will be found to deploy the helicopter down from the vehicle and place it onto the ground. The rover then will be driven away from the helicopter to a safe distance from which it will relay commands. After its batteries are charged and a myriad of tests are performed, controllers on Earth will command the Mars Helicopter to take its first autonomous flight into history.\n“We don’t have a pilot and Earth will be several light minutes away, so there is no way to joystick this mission in real time,” said Aung. “Instead, we have an autonomous capability that will be able to receive and interpret commands from the ground, and then fly the mission on its own.”\nThe full 30-day flight test campaign will include up to five flights of incrementally farther flight distances, up to a few hundred meters, and longer durations as long as 90 seconds, over a period. On its first flight, the helicopter will make a short vertical climb to 10 feet (3 meters), where it will hover for about 30 seconds.\nAs a technology demonstration, the Mars Helicopter is considered a high-risk, high-reward project. If it does not work, the Mars 2020 mission will not be impacted. If it does work, helicopters may have a real future as low-flying scouts and aerial vehicles to access locations not reachable by ground travel.\n“The ability to see clearly what lies beyond the next hill is crucial for future explorers,” said Zurbuchen. “We already have great views of Mars from the surface as well as from orbit. With the added dimension of a bird’s-eye view from a ‘marscopter,’ we can only imagine what future missions will achieve.”\nMars 2020 will launch on a United Launch Alliance (ULA) Atlas V rocket from Space Launch Complex 41 at Cape Canaveral Air Force Station in Florida, and is expected to reach Mars in February 2021.\nThe rover will conduct geological assessments of its landing site on Mars, determine the habitability of the environment, search for signs of ancient Martian life, and assess natural resources and hazards for future human explorers. Scientists will use the instruments aboard the rover to identify and collect samples of rock and soil, encase them in sealed tubes, and leave them on the planet’s surface for potential return to Earth on a future Mars mission.\nThe Mars 2020 Project at JPL in Pasadena, California, manages rover development for the Science Mission Directorate at NASA Headquarters in Washington. NASA’s Launch Services Program, based at the agency’s Kennedy Space Center in Florida, is responsible for launch management.\nFor more information about NASA’s Mars missions, go to:\nhttps://www.nasa.gov/mars\nNews Media Contacts:\nDC Agle\nJet Propulsion Laboratory, Pasadena, Calif.\n818-393-9011\nagle@jpl.nasa.gov\nDwayne Brown / JoAnna Wendel\nNASA Headquarters, Washington\n202-358-1726 / 202-358-1003\ndwayne.c.brown@nasa.gov / joanna.r.wendel@nasa.gov\n"}




```python
browser = init_browser()
featured_image_url = []
url = "https://www.jpl.nasa.gov/spaceimages/?search=&category=Mars"
browser.visit(url)
time.sleep(2)
html = browser.html
soup = BeautifulSoup(html, "html.parser")
try: 
    xpath = '//*[contains(@class, "button fancybox")]'
    results = browser.find_by_xpath(xpath)
    img = results[0]
    img.click()
    time.sleep(2)
    html = browser.html
    soup = BeautifulSoup(html, "html.parser")
    elem = soup.find(id="fancybox-lock")
    img_src = elem.find("img")["src"]

except AttributeError:
        print ("Error found")
```


```python
img_src
```




    '/spaceimages/images/mediumsize/PIA01486_ip.jpg'




```python
#Concatting the img src to the URL
featured_image_url = 'www.jpl.nasa.gov' + img_src
```


```python
featured_image_url
```




    'www.jpl.nasa.gov/spaceimages/images/mediumsize/PIA01486_ip.jpg'




```python
#Looping through the Mars Report on Twitter and grabbing the most recent Tweet
browser = init_browser()
last_tweet = []
#Setting url to website
url = "https://twitter.com/marswxreport?lang=en"
browser.visit(url)
time.sleep(2)
#grabbing html
html = browser.html
soup = BeautifulSoup(html, "html.parser")
#Clicking the most recent tweet and collecting data

try:
    xpath = '//*[contains(@class, "js-tweet-text-container")]'
    results = browser.find_by_xpath(xpath)
    img = results[0]
    img.click()
    time.sleep(6)
    html = browser.html
    soup = BeautifulSoup(html, "html.parser")
    last_tweet = soup.find(class_="TweetTextSize TweetTextSize--jumbo js-tweet-text tweet-text").get_text()
except AttributeError:
        print ("Error found")
```


```python
print(last_tweet)
```

    Sol 2047 (May 10, 2018), Sunny, high 3C/37F, low -71C/-95F, pressure at 7.33 hPa, daylight 05:22-17:20
    


```python
Key_lime = []
#Looping through Space  website and grabbing the keys to build a DF
browser = init_browser()
#Setting url to website
url = "https://space-facts.com/mars/"
browser.visit(url)
time.sleep(2)
#grabbing html
html = browser.html
soup = BeautifulSoup(html, "html.parser")
for strong_tag in soup.find_all('strong'):
    Key_lime.append(strong_tag.text)

```


```python
v_tagz = []
#Looping through Space  website and grabbing the values to build a DF
browser = init_browser()
#Setting url to website
url = "https://space-facts.com/mars/"
browser.visit(url)
time.sleep(2)
#grabbing html
html = browser.html
soup = BeautifulSoup(html, "html.parser")
for v_tag in soup.find_all(class_='column-2'):
    v_tagz.append(v_tag.text)
```


```python
#Creating a DF with the table keys and values
df = pd.DataFrame(
    {'Keys': Key_lime[:9],
     'Values': v_tagz,
    })
df
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
      <th>Keys</th>
      <th>Values</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>Equatorial Diameter:</td>
      <td>6,792 km\n</td>
    </tr>
    <tr>
      <th>1</th>
      <td>Polar Diameter:</td>
      <td>6,752 km\n</td>
    </tr>
    <tr>
      <th>2</th>
      <td>Mass:</td>
      <td>6.42 x 10^23 kg (10.7% Earth)</td>
    </tr>
    <tr>
      <th>3</th>
      <td>Moons:</td>
      <td>2 (Phobos &amp; Deimos)</td>
    </tr>
    <tr>
      <th>4</th>
      <td>Orbit Distance:</td>
      <td>227,943,824 km (1.52 AU)</td>
    </tr>
    <tr>
      <th>5</th>
      <td>Orbit Period:</td>
      <td>687 days (1.9 years)\n</td>
    </tr>
    <tr>
      <th>6</th>
      <td>Surface Temperature:</td>
      <td>-153 to 20 °C</td>
    </tr>
    <tr>
      <th>7</th>
      <td>First Record:</td>
      <td>2nd millennium BC</td>
    </tr>
    <tr>
      <th>8</th>
      <td>Recorded By:</td>
      <td>Egyptian astronomers</td>
    </tr>
  </tbody>
</table>
</div>




```python
#Converting to html
df.to_html('Output/Mars_Table.html')
```


```python
#Going to the Astrogeology  website and clicking on each of the 4 mars images to get full size and grabbing their title
Astro_title = []
Astro_img = []    
browser = init_browser()
url = "https://astrogeology.usgs.gov/search/results?q=hemisphere+enhanced&k1=target&v1=Mars"
browser.visit(url)
time.sleep(2)
#grabbing html
html = browser.html
soup = BeautifulSoup(html, "html.parser")
#Grabbing title and paragraph text

try:
    #Pulling data from Cerberus Page
    xpath = '//*[contains(@src,"/cache/images/dfaf3849e74bf973b59eb50dab52b583_cerberus_enhanced.tif_thumb.png")]'
    results = browser.find_by_xpath(xpath)
    img = results[0]
    img.click()
    time.sleep(6)
    html = browser.html
    soup = BeautifulSoup(html, "html.parser")
    Astro_title.append(soup.find(class_='title').text)
    all_Images = soup.find("div", {"downloads"},{"img"})
    Astro_img.append(all_Images.find('a', href=True)['href'])
    
    #Pulling data from Schiaparelli Page
    
    browser.execute_script("window.history.go(-1)")
    time.sleep(2)
    xpath = '//*[contains(@src,"/cache/images/7677c0a006b83871b5a2f66985ab5857_schiaparelli_enhanced.tif_thumb.png")]'
    results = browser.find_by_xpath(xpath)
    img = results[0]
    img.click()
    time.sleep(2)
    html = browser.html
    soup = BeautifulSoup(html, "html.parser")
    Astro_title.append(soup.find(class_='title').text)
    all_Images = soup.find("div", {"downloads"},{"img"})
    Astro_img.append(all_Images.find('a', href=True)['href'])
    
        #Pulling data from Syrtus Page
    
    browser.execute_script("window.history.go(-1)")
    time.sleep(2)
    xpath = '//*[contains(@src,"/cache/images/aae41197e40d6d4f3ea557f8cfe51d15_syrtis_major_enhanced.tif_thumb.png")]'
    results = browser.find_by_xpath(xpath)
    img = results[0]
    img.click()
    time.sleep(2)
    html = browser.html
    soup = BeautifulSoup(html, "html.parser")
    Astro_title.append(soup.find(class_='title').text)
    all_Images = soup.find("div", {"downloads"},{"img"})
    Astro_img.append(all_Images.find('a', href=True)['href'])
    
            #Pulling data from Valles Marineras Page
    
    browser.execute_script("window.history.go(-1)")
    time.sleep(2)
    xpath = '//*[contains(@src,"/cache/images/aae41197e40d6d4f3ea557f8cfe51d15_syrtis_major_enhanced.tif_thumb.png")]'
    results = browser.find_by_xpath(xpath)
    img = results[0]
    img.click()
    time.sleep(2)
    html = browser.html
    soup = BeautifulSoup(html, "html.parser")
    Astro_title.append(soup.find(class_='title').text)
    all_Images = soup.find("div", {"downloads"},{"img"})
    Astro_img.append(all_Images.find('a', href=True)['href'])

except AttributeError:
        print ("Error found")
```


```python
#Placing the Mars image and title into a DF
Mars_Hemisphere = pd.DataFrame(
    {'Title': Astro_title,
     'Link': Astro_img,
    })
pd.set_option('display.max_colwidth', -1)
Mars_Hemisphere
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
      <th>Link</th>
      <th>Title</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>0</th>
      <td>http://astropedia.astrogeology.usgs.gov/download/Mars/Viking/cerberus_enhanced.tif/full.jpg</td>
      <td>Cerberus Hemisphere Enhanced</td>
    </tr>
    <tr>
      <th>1</th>
      <td>http://astropedia.astrogeology.usgs.gov/download/Mars/Viking/schiaparelli_enhanced.tif/full.jpg</td>
      <td>Schiaparelli Hemisphere Enhanced</td>
    </tr>
    <tr>
      <th>2</th>
      <td>http://astropedia.astrogeology.usgs.gov/download/Mars/Viking/syrtis_major_enhanced.tif/full.jpg</td>
      <td>Syrtis Major Hemisphere Enhanced</td>
    </tr>
    <tr>
      <th>3</th>
      <td>http://astropedia.astrogeology.usgs.gov/download/Mars/Viking/syrtis_major_enhanced.tif/full.jpg</td>
      <td>Syrtis Major Hemisphere Enhanced</td>
    </tr>
  </tbody>
</table>
</div>




```python
Mars_Hemisphere.to_html("Output/Mars_Hemisphere.html")
```
