
# coding: utf-8

# In[ ]:


#The Name column should be split into separate First Name and Last Name columns.
#The DOB data should be re-written into DD/MM/YYYY format.
#The SSN data should be re-written such that the first five numbers are hidden from view.
#The State data should be re-written as simple two-letter abbreviations.

import pandas as pd
import numpy as np
import os
import csv


# In[ ]:


csv_path = "Generators/employee_data1.csv"
#csv_path = "Generators/employee_data2.csv"

boss_df = pd.read_csv(csv_path, encoding="utf-8")
boss_df.head()


# In[ ]:


#Splitting names into new df
split_name = pd.DataFrame=boss_df["Name"].str.split(" ", expand=True).astype(str)
split_name.columns = ['First', 'Last']
split_name.head()


# In[ ]:


#Merging
merge_df = pd.concat([split_name, boss_df], axis = 1)
merge_df.head()


# In[ ]:


#Removing old names names
rename_df=merge_df.drop(['Name'], axis=1)

rename_df.head()


# In[ ]:


#Converting to date and time
rename_df['DOB'] = pd.to_datetime(rename_df.DOB)
rename_df['DOB'] = rename_df['DOB'].dt.strftime('%m/%d/%Y')
rename_df.head()


# In[ ]:


#Trimming SSN numbers we want to mask
rename_df['SSN'] = rename_df['SSN'].str[5:]
rename_df.head()


# In[ ]:


#Creating a column to concatinate for the trimmed numbers
rename_df['Mask']='xxxxx'
rename_df.head()


# In[ ]:


#making a new column with the concatinated masked
rename_df['Masked SSN'] = rename_df.Mask.str.cat(rename_df.SSN)
rename_df.head()


# In[ ]:


#Removing the old SSN columns
masked_df=rename_df.drop(['SSN', "Mask"], axis=1)
masked_df


# In[ ]:


us_state = {
    'Alabama': 'AL',
    'Alaska': 'AK',
    'Arizona': 'AZ',
    'Arkansas': 'AR',
    'California': 'CA',
    'Colorado': 'CO',
    'Connecticut': 'CT',
    'Delaware': 'DE',
    'Florida': 'FL',
    'Georgia': 'GA',
    'Hawaii': 'HI',
    'Idaho': 'ID',
    'Illinois': 'IL',
    'Indiana': 'IN',
    'Iowa': 'IA',
    'Kansas': 'KS',
    'Kentucky': 'KY',
    'Louisiana': 'LA',
    'Maine': 'ME',
    'Maryland': 'MD',
    'Massachusetts': 'MA',
    'Michigan': 'MI',
    'Minnesota': 'MN',
    'Mississippi': 'MS',
    'Missouri': 'MO',
    'Montana': 'MT',
    'Nebraska': 'NE',
    'Nevada': 'NV',
    'New Hampshire': 'NH',
    'New Jersey': 'NJ',
    'New Mexico': 'NM',
    'New York': 'NY',
    'North Carolina': 'NC',
    'North Dakota': 'ND',
    'Ohio': 'OH',
    'Oklahoma': 'OK',
    'Oregon': 'OR',
    'Pennsylvania': 'PA',
    'Rhode Island': 'RI',
    'South Carolina': 'SC',
    'South Dakota': 'SD',
    'Tennessee': 'TN',
    'Texas': 'TX',
    'Utah': 'UT',
    'Vermont': 'VT',
    'Virginia': 'VA',
    'Washington': 'WA',
    'West Virginia': 'WV',
    'Wisconsin': 'WI',
    'Wyoming': 'WY',
}


# In[ ]:


masked_df['States'] = masked_df['State'].map(us_state)
masked_df.head()


# In[ ]:


masked_df=masked_df.drop(['State'], axis=1)
masked_df.head()


# In[ ]:


masked_df.to_csv("Output_csv.csv", index=False, header=True)

