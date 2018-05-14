# Importing dependencies
import time
from splinter import Browser
from bs4 import BeautifulSoup
from selenium import webdriver
import pandas as pd
import numpy as np

# Executing Chrome Driver for auto navigation to click links


def init_browser():
    executable_path = {
        'executable_path': r'C:\Users\Craig\Desktop\chromedriver.exe'}
    return Browser("chrome", **executable_path, headless=False)


def scrape():

# Looping through Nasa website and grabbing the latest title and news
    browser = init_browser()
    listing = {}

# Setting url to website
    url = "https://mars.nasa.gov/news/?page=0&per_page=40&order=publish_date+desc%2Ccreated_at+desc&search=&category=19%2C165%2C184%2C204&blank_scope=Latest"
    browser.visit(url)
    time.sleep(2)

# grabbing html
    html = browser.html
    soup = BeautifulSoup(html, "html.parser")

# Grabbing title and paragraph text
    listing["News_Title"] = soup.find(class_="content_title").get_text()
    listing["Newsp"] = soup.find(class_="article_teaser_body").get_text()
    
# Grabbing feature picture   
    time.sleep(5)
    
    featured_image_url = []
    url = "https://www.jpl.nasa.gov/spaceimages/?search=&category=Mars"
    browser.visit(url)
    time.sleep(2)
    html = browser.html
    soup = BeautifulSoup(html, "html.parser")

    xpath = '//*[contains(@class, "button fancybox")]'
    results = browser.find_by_xpath(xpath)
    img = results[0]
    img.click()
    time.sleep(2)
    html = browser.html
    soup = BeautifulSoup(html, "html.parser")
    elem = soup.find(id="fancybox-lock")
    img_src = elem.find("img")["src"]

    featured_image_url = 'https://www.jpl.nasa.gov' + img_src
    listing['featured_image_url'] = featured_image_url

# Grabbing Tweet
    time.sleep(8)
    url = "https://twitter.com/marswxreport?lang=en"
    browser.visit(url)
    time.sleep(7)
    html = browser.html
    soup = BeautifulSoup(html, "html.parser")
    xpath = '//*[contains(@class, "js-tweet-text-container")]'
    results = browser.find_by_xpath(xpath)
    img = results[0]
    img.click()
    time.sleep(5)
    html = browser.html
    soup = BeautifulSoup(html, "html.parser")
    last_tweet = soup.find(class_="TweetTextSize TweetTextSize--jumbo js-tweet-text tweet-text").get_text()
    listing['New_Tweet']=last_tweet

# Grabbing Mars Photos
    time.sleep(5)
    url = "https://astrogeology.usgs.gov/search/results?q=hemisphere+enhanced&k1=target&v1=Mars"
    browser.visit(url)
    time.sleep(2)
    #grabbing html
    html = browser.html
    soup = BeautifulSoup(html, "html.parser")

        #Pulling data from Cerberus Page
    xpath = '//*[contains(@src,"/cache/images/dfaf3849e74bf973b59eb50dab52b583_cerberus_enhanced.tif_thumb.png")]'
    results = browser.find_by_xpath(xpath)
    img = results[0]
    img.click()
    time.sleep(6)
    html = browser.html
    soup = BeautifulSoup(html, "html.parser")
    listing["cerb_title"] = soup.find(class_='title').text
    all_Images = soup.find("div", {"downloads"},{"img"})
    listing['cerb_img'] = all_Images.find('a', href=True)['href']
    
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
    listing["schia_title"] = soup.find(class_='title').text
    all_Images = soup.find("div", {"downloads"},{"img"})
    listing['schia_img'] = all_Images.find('a', href=True)['href']
    
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
    listing["syrtus_title"] = soup.find(class_='title').text
    all_Images = soup.find("div", {"downloads"},{"img"})
    listing['syrtus_img'] = all_Images.find('a', href=True)['href']
    
        #Pulling data from Valles Marineras Page
    browser.execute_script("window.history.go(-1)")
    time.sleep(2)
    xpath = '//*[contains(@src,"/cache/images/04085d99ec3713883a9a57f42be9c725_valles_marineris_enhanced.tif_thumb.png")]'
    results = browser.find_by_xpath(xpath)
    img = results[0]
    img.click()
    time.sleep(2)
    html = browser.html
    soup = BeautifulSoup(html, "html.parser")
    listing["vm_title"] = soup.find(class_='title').text
    all_Images = soup.find("div", {"downloads"},{"img"})
    listing['vm_img'] = all_Images.find('a', href=True)['href']
    
    return listing
