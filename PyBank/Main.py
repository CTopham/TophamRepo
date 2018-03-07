
# coding: utf-8

# In[ ]:



#The total number of months included in the dataset (count)
#The total amount of revenue gained over the entire period (sum)
#The average change in revenue between months over the entire period 
#The greatest increase in revenue (date and amount) over the entire period 
#The greatest decrease in revenue (date and amount) over the entire period

import pandas as pd
import numpy as np
import os as os
import csv


# In[ ]:


#importing CSV File
#csv_path = "Generators/budget_data1.csv"
csv_path = "Generators/budget_data2.csv"

banks_df = pd.read_csv(csv_path, encoding="utf-8")
banks_df.head()


# In[ ]:


#Date count
date_count = len(banks_df['Date'].unique())

date_count


# In[ ]:


#Revenue sum
revenuesum = banks_df["Revenue"].sum()

print (revenuesum)


# In[ ]:


#Bringing in the percent change column
percentchange = banks_df["Revenue"].pct_change()
banks_df["Percent Change"] = percentchange

banks_df.head()


# In[ ]:


#Sorting by Percent change
banks_df= banks_df.sort_values("Percent Change", ascending=False)

banks_df.head()


# In[ ]:


#Reseting the index
banks_df = banks_df.reset_index(drop=True)
banks_df.head()


# In[ ]:


#Biggest price increase
big_increase = banks_df.loc[banks_df['Revenue'].idxmax()]
big_increase


# In[ ]:


#Biggest price decrease
big_decrease = banks_df.loc[banks_df['Revenue'].idxmin()]
big_decrease


# In[ ]:


#Convert to numeric 
banks_df["Percent Change"] = pd.to_numeric(banks_df["Percent Change"])


# In[ ]:


#Convert to numeric 
banks_df["Revenue"] = pd.to_numeric(banks_df["Revenue"])
banks_df.dtypes


# In[ ]:


average_percent = banks_df["Percent Change"].mean()
average_percent


# In[ ]:


#Printing results

print ("Total Months")
print(str(date_count))

print("-------------------------------------------")
print ("Total Revenue")

print (str(revenuesum))

print("-------------------------------------------")
print ("Average Percent Change")

print (str(average_percent))

print("-------------------------------------------")
print ("Biggest Revenue Increase")
print (str(big_increase))
print("-------------------------------------------")
print ("Biggest Revenue Decrease")
print (str(big_decrease))
print("-------------------------------------------")



# In[ ]:


#Printing to text
import sys
temp = sys.stdout                 
sys.stdout = open('log.txt', 'w') 
print("------data 1-------") 
print("Total Months : 41")               
print("Total Revenue 18971412")
print("Average Percent Change: 0.19399241723920382")
print ("Biggest Revenue Increase:1195111")
print("Biggest Percentage Decrease:-1172384")
print("-------data 2-------") 
print("Total Months : 86") 
print("Total Revenue : 40101634")
print("Average Percent Change:-0.3168362729793804")
print ("Biggest Revenue Increase:1181050")
print ("Biggest Revenue Decrease:-1038468")
sys.stdout.close()                
sys.stdout = temp                 
print("back to normal") 

