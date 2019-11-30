# Importing dependencies
import time
from splinter import Browser
from bs4 import BeautifulSoup
from selenium import webdriver
import pandas as pd
import numpy as np
from shodan import Shodan
import shodan
import sys
import socket 
#Keys to the kingdom
from Config import API
# Executing Chrome Driver for auto navigation to click links


def init_browser():
    executable_path = {
        'executable_path': r'C:\Users\14804\Desktop\chromedriver.exe'}
    return Browser("chrome", **executable_path, headless=False)

def tweet():
    browser = init_browser()
    listing = {}

    # Grabbing Tweet
    time.sleep(8)
    url = "https://twitter.com/CVEnew"
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
    return listing

def scrape():

# Looping through Nasa website and grabbing the latest title and news
    browser = init_browser()
    listing = {}

# Grabbing Tweet
    time.sleep(8)
    url = "https://twitter.com/cyber?lang=en"
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
    
    return listing

