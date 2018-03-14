

```python
#Craig Topham 
#School Analysis

#Dependencies
import pandas as pd
import numpy as np

```


```python
#Pathing inputs
csv_school = "raw_data/schools_complete.csv"
csv_student = "raw_data/students_complete.csv"
```


```python
#Reading files
school_df = pd.read_csv(csv_school)
student_df = pd.read_csv(csv_student)
school_df.head(15)
```


```python
student_df.head()
```


```python
student_df.count()
```


```python
#Getting the number of schools
school_count = len(school_df.index)
school_count
```


```python
#Grabbing student count
student_count = len (student_df.index)
student_count

```


```python
#Total Budget
total_budget = school_df["budget"].sum()
total_budget
```


```python
#Looking at column names for any future issues
student_df.columns
```


```python
#Average Math score
average_math = student_df["math_score"].mean()
average_math
```


```python
#Average reading score
average_reading = student_df["reading_score"].mean()
average_reading
```


```python
# % passing math
#Looping to place a "p" in a list for each pass
math_passer= []
for row in student_df['math_score']:
    if row >= 70:
        math_passer.append('p')
    
```


```python
# % passing math..cont..
#placing "p" in list for a count 
math_df=pd.DataFrame(math_passer)
x = len (math_df.index)
x
```


```python
# % passing math..cont..
#dividing passers by total students 
math_pass_percentage = x / student_count
math_pass_percentage
```


```python
# % passing reading
#Looping to place a "p" in a list for each pass
read_passer= []
for row in student_df['reading_score']:
    if row >= 70:
        read_passer.append('p')
```


```python
# % passing reading..cont..
#placing "p" in list for a count 
read_df=pd.DataFrame(read_passer)
y = len (read_df.index)
y
```


```python
# % passing reading..cont..
#dividing passers by total students
read_pass_percentage = y / student_count
read_pass_percentage
```


```python
#Calculating the combined percentage of passing students
passers=read_pass_percentage + math_pass_percentage
combined_pass = passers / 2
combined_pass
```


```python
#-----------------------------------------------------------------
#Final District Summary
#-----------------------------------------------------------------
district_summary_table = pd.DataFrame({"School Count":school_count,
                             "Student Count":[student_count],
                             "Total Budget":[total_budget],
                             "Average Math Score":[average_math],
                             "Average Reading Score":[average_reading],
                             "Math Pass %":[math_pass_percentage],
                             "Reading Pass %":[read_pass_percentage],
                              "Combined Pass Percent":[combined_pass]})

district_summary_table = district_summary_table[["School Count","Student Count","Total Budget","Average Math Score","Average Reading Score","Math Pass %","Reading Pass %","Combined Pass Percent"]]
district_summary_table.head()
```


```python
#Exporting
district_summary_table.to_excel("Output/District Summary.xlsx", index=False, header=True)
```


```python
#renaming school column to match so I can merge on it
school_df.rename(columns={'name':'school'}, inplace=True)
school_df.head()
                 
```


```python
# game plan for 2nd question

#create a df with all the data you need combined = merged_df
#grab all schools info
#complete a use case after two school on a concat / merge
#combined the findings with a merge or concat after all schools are iterated
```


```python
school_df["school"].unique
```


```python
#merging on school
merged_df = pd.merge(school_df, student_df, on="school")
merged_df.tail()
```


```python
#Making a combined percentage column
merged_df["Combined Score Percentage"]= merged_df["reading_score"]+merged_df["math_score"]
merged_df.loc[:,'Combined Score Percentage'] /= 200
merged_df.head()
```


```python
#Creating a DF with pena school resetting index
#PENA HIGHSCHOOL
pena_df = merged_df.loc[merged_df["school"]=="Pena High School",:]
pena_df = pena_df.reset_index(drop=True)
pena_df.head()
```


```python
#Grabing all pena high school info
pena_school_name = pena_df.iloc[0,1]
pena_school_name
```


```python
#Getting School Type
pena_school_type = pena_df.iloc[0,2]
pena_school_type
```


```python
#Total Students
pena_total_students = pena_df.iloc[0,3]
pena_total_students
```


```python
#Budget
pena_budget = pena_df.iloc[0,4]
pena_budget
```


```python
#Budget per student
pena_budget_per_student = pena_budget / pena_total_students
pena_budget_per_student
```


```python
#Average math score
pena_ave_math = pena_df['math_score'].mean()
pena_ave_math
```


```python
#Average reading score
pena_ave_read = pena_df['reading_score'].mean()
pena_ave_read
```


```python
#Percent passing math at Pena
#Looping to place a "p" in a list for each pass
math_passer= []
for row in pena_df['math_score']:
    if row >= 70:
        math_passer.append('p')
math_df=pd.DataFrame(math_passer)
x = len (math_df.index)
math_pass_percentage = x / pena_total_students
math_pass_percentage
```


```python
#Percent passing reading at Pena
#Looping to place a "p" in a list for each pass
read_passer= []
for row in pena_df['reading_score']:
    if row >= 70:
        read_passer.append('p')
read_df=pd.DataFrame(read_passer)
x = len (read_df.index)
read_pass_percentage = x / pena_total_students
read_pass_percentage
```


```python
#Grab all the data that is required
#combined score percentage
pena_combined_ave = pena_df['Combined Score Percentage'].mean()
pena_combined_ave
```


```python
passers=read_pass_percentage + math_pass_percentage
combined_pass = passers / 2
combined_pass
```


```python
#----------------------
#Pena School Dataframe
#---------------------
pena_summary_table = pd.DataFrame({"School Name":pena_school_name,
                             "Type":[pena_school_type],
                             "Total Students":[pena_total_students],
                             "Budget":[pena_budget],
                             "Budget Per Student":[pena_budget_per_student],
                             "Average Math Score":[pena_ave_math],
                             "Average Reading Score":[pena_ave_read],
                             "% Passing Math":[math_pass_percentage],
                             "% Passing Reading":[read_pass_percentage],
                              "Overall Passing":[combined_pass]})

pena_summary_table = pena_summary_table[["School Name","Type","Total Students","Budget","Budget Per Student","Average Math Score","Average Reading Score","% Passing Math", "% Passing Reading", "Overall Passing"]]

pena_summary_table.head()
```


```python
#Creating a DF with Huang school resetting index
#Huang High School
huang_df = merged_df.loc[merged_df["school"]=="Huang High School",:]
huang_df = huang_df.reset_index(drop=True)
huang_df.head()
```


```python
#-----------------------------------------------------
#Consolidating the previous info obtained on Pena high school and applying to all 15 schools
#-----------------------------------------------------
#Grabbing all huang high school info
huang_school_name = huang_df.iloc[0,1]
huang_school_type = huang_df.iloc[0,2]
huang_total_students = huang_df.iloc[0,3]
huang_budget = huang_df.iloc[0,4]
huang_budget_per_student = huang_budget / huang_total_students
huang_ave_math = huang_df['math_score'].mean()
huang_ave_read = huang_df['reading_score'].mean()

#Percent passing math at huang
#Looping to place a "p" in a list for each pass
math_passer= []
for row in huang_df['math_score']:
    if row >= 70:
        math_passer.append('p')
math_df=pd.DataFrame(math_passer)
x = len (math_df.index)
math_pass_percentage = x / huang_total_students

#Percent passing reading at huang
#Looping to place a "p" in a list for each pass
read_passer= []
for row in huang_df['reading_score']:
    if row >= 70:
        read_passer.append('p')
read_df=pd.DataFrame(read_passer)
x = len (read_df.index)
read_pass_percentage = x / huang_total_students

passers=read_pass_percentage + math_pass_percentage
combined_pass = passers / 2

#----------------------
#huang School Dataframe
#---------------------
huang_summary_table = pd.DataFrame({"School Name":huang_school_name,
                             "Type":[huang_school_type],
                             "Total Students":[huang_total_students],
                             "Budget":[huang_budget],
                             "Budget Per Student":[huang_budget_per_student],
                             "Average Math Score":[huang_ave_math],
                             "Average Reading Score":[huang_ave_read],
                             "% Passing Math":[math_pass_percentage],
                             "% Passing Reading":[read_pass_percentage],
                              "Overall Passing":[combined_pass]})

huang_summary_table = huang_summary_table[["School Name","Type","Total Students","Budget","Budget Per Student","Average Math Score","Average Reading Score","% Passing Math", "% Passing Reading", "Overall Passing"]]

huang_summary_table.head()
```


```python
#Creating a DF with Figueroa school resetting index
#Figueroa High School
Figueroa_df = merged_df.loc[merged_df["school"]=="Figueroa High School",:]
Figueroa_df = Figueroa_df.reset_index(drop=True)
Figueroa_df.head()
```


```python
#Grabbing all Figueroa high school info
Figueroa_school_name = Figueroa_df.iloc[0,1]
Figueroa_school_type = Figueroa_df.iloc[0,2]
Figueroa_total_students = Figueroa_df.iloc[0,3]
Figueroa_budget = Figueroa_df.iloc[0,4]
Figueroa_budget_per_student = Figueroa_budget / Figueroa_total_students
Figueroa_ave_math = Figueroa_df['math_score'].mean()
Figueroa_ave_read = Figueroa_df['reading_score'].mean()

#Percent passing math at Figueroa
#Looping to place a "p" in a list for each pass
math_passer= []
for row in Figueroa_df['math_score']:
    if row >= 70:
        math_passer.append('p')
math_df=pd.DataFrame(math_passer)
x = len (math_df.index)
math_pass_percentage = x / Figueroa_total_students

#Percent passing reading at Figueroa
#Looping to place a "p" in a list for each pass
read_passer= []
for row in Figueroa_df['reading_score']:
    if row >= 70:
        read_passer.append('p')
read_df=pd.DataFrame(read_passer)
x = len (read_df.index)
read_pass_percentage = x / Figueroa_total_students

passers=read_pass_percentage + math_pass_percentage
combined_pass = passers / 2

#----------------------
#Figueroa School Dataframe
#---------------------
Figueroa_summary_table = pd.DataFrame({"School Name":Figueroa_school_name,
                             "Type":[Figueroa_school_type],
                             "Total Students":[Figueroa_total_students],
                             "Budget":[Figueroa_budget],
                             "Budget Per Student":[Figueroa_budget_per_student],
                             "Average Math Score":[Figueroa_ave_math],
                             "Average Reading Score":[Figueroa_ave_read],
                             "% Passing Math":[math_pass_percentage],
                             "% Passing Reading":[read_pass_percentage],
                              "Overall Passing":[combined_pass]})

Figueroa_summary_table = Figueroa_summary_table[["School Name","Type","Total Students","Budget","Budget Per Student","Average Math Score","Average Reading Score","% Passing Math", "% Passing Reading", "Overall Passing"]]

Figueroa_summary_table.head()
```


```python
#Creating a DF with Shelton school resetting index
#Shelton High School
Shelton_df = merged_df.loc[merged_df["school"]=="Shelton High School",:]
Shelton_df = Shelton_df.reset_index(drop=True)
Shelton_df.head()
```


```python
#Grabbing all Shelton high school info
Shelton_school_name = Shelton_df.iloc[0,1]
Shelton_school_type = Shelton_df.iloc[0,2]
Shelton_total_students = Shelton_df.iloc[0,3]
Shelton_budget = Shelton_df.iloc[0,4]
Shelton_budget_per_student = Shelton_budget / Shelton_total_students
Shelton_ave_math = Shelton_df['math_score'].mean()
Shelton_ave_read = Shelton_df['reading_score'].mean()

#Percent passing math at Shelton
#Looping to place a "p" in a list for each pass
math_passer= []
for row in Shelton_df['math_score']:
    if row >= 70:
        math_passer.append('p')
math_df=pd.DataFrame(math_passer)
x = len (math_df.index)
math_pass_percentage = x / Shelton_total_students

#Percent passing reading at Shelton
#Looping to place a "p" in a list for each pass
read_passer= []
for row in Shelton_df['reading_score']:
    if row >= 70:
        read_passer.append('p')
read_df=pd.DataFrame(read_passer)
x = len (read_df.index)
read_pass_percentage = x / Shelton_total_students

passers=read_pass_percentage + math_pass_percentage
combined_pass = passers / 2

#----------------------
#Shelton School Dataframe
#---------------------
Shelton_summary_table = pd.DataFrame({"School Name":Shelton_school_name,
                             "Type":[Shelton_school_type],
                             "Total Students":[Shelton_total_students],
                             "Budget":[Shelton_budget],
                             "Budget Per Student":[Shelton_budget_per_student],
                             "Average Math Score":[Shelton_ave_math],
                             "Average Reading Score":[Shelton_ave_read],
                             "% Passing Math":[math_pass_percentage],
                             "% Passing Reading":[read_pass_percentage],
                              "Overall Passing":[combined_pass]})

Shelton_summary_table = Shelton_summary_table[["School Name","Type","Total Students","Budget","Budget Per Student","Average Math Score","Average Reading Score","% Passing Math", "% Passing Reading", "Overall Passing"]]

Shelton_summary_table.head()
```


```python
#Creating a DF with Hernandez school resetting index
#Hernandez High School
Hernandez_df = merged_df.loc[merged_df["school"]=="Hernandez High School",:]
Hernandez_df = Hernandez_df.reset_index(drop=True)
Hernandez_df.head()
```


```python
#Grabbing all Hernandez high school info
Hernandez_school_name = Hernandez_df.iloc[0,1]
Hernandez_school_type = Hernandez_df.iloc[0,2]
Hernandez_total_students = Hernandez_df.iloc[0,3]
Hernandez_budget = Hernandez_df.iloc[0,4]
Hernandez_budget_per_student = Hernandez_budget / Hernandez_total_students
Hernandez_ave_math = Hernandez_df['math_score'].mean()
Hernandez_ave_read = Hernandez_df['reading_score'].mean()

#Percent passing math at Hernandez
#Looping to place a "p" in a list for each pass
math_passer= []
for row in Hernandez_df['math_score']:
    if row >= 70:
        math_passer.append('p')
math_df=pd.DataFrame(math_passer)
x = len (math_df.index)
math_pass_percentage = x / Hernandez_total_students

#Percent passing reading at Hernandez
#Looping to place a "p" in a list for each pass
read_passer= []
for row in Hernandez_df['reading_score']:
    if row >= 70:
        read_passer.append('p')
read_df=pd.DataFrame(read_passer)
x = len (read_df.index)
read_pass_percentage = x / Hernandez_total_students

passers=read_pass_percentage + math_pass_percentage
combined_pass = passers / 2

#----------------------
#Hernandez School Dataframe
#---------------------
Hernandez_summary_table = pd.DataFrame({"School Name":Hernandez_school_name,
                             "Type":[Hernandez_school_type],
                             "Total Students":[Hernandez_total_students],
                             "Budget":[Hernandez_budget],
                             "Budget Per Student":[Hernandez_budget_per_student],
                             "Average Math Score":[Hernandez_ave_math],
                             "Average Reading Score":[Hernandez_ave_read],
                             "% Passing Math":[math_pass_percentage],
                             "% Passing Reading":[read_pass_percentage],
                              "Overall Passing":[combined_pass]})

Hernandez_summary_table = Hernandez_summary_table[["School Name","Type","Total Students","Budget","Budget Per Student","Average Math Score","Average Reading Score","% Passing Math", "% Passing Reading", "Overall Passing"]]

Hernandez_summary_table.head()
```


```python
#Creating a DF with Griffin school resetting index
#Griffin High School
Griffin_df = merged_df.loc[merged_df["school"]=="Griffin High School",:]
Griffin_df = Griffin_df.reset_index(drop=True)
Griffin_df.head()
```


```python
#Grabbing all Griffin high school info
Griffin_school_name = Griffin_df.iloc[0,1]
Griffin_school_type = Griffin_df.iloc[0,2]
Griffin_total_students = Griffin_df.iloc[0,3]
Griffin_budget = Griffin_df.iloc[0,4]
Griffin_budget_per_student = Griffin_budget / Griffin_total_students
Griffin_ave_math = Griffin_df['math_score'].mean()
Griffin_ave_read = Griffin_df['reading_score'].mean()

#Percent passing math at Griffin
#Looping to place a "p" in a list for each pass
math_passer= []
for row in Griffin_df['math_score']:
    if row >= 70:
        math_passer.append('p')
math_df=pd.DataFrame(math_passer)
x = len (math_df.index)
math_pass_percentage = x / Griffin_total_students

#Percent passing reading at Griffin
#Looping to place a "p" in a list for each pass
read_passer= []
for row in Griffin_df['reading_score']:
    if row >= 70:
        read_passer.append('p')
read_df=pd.DataFrame(read_passer)
x = len (read_df.index)
read_pass_percentage = x / Griffin_total_students

passers=read_pass_percentage + math_pass_percentage
combined_pass = passers / 2

#----------------------
#Griffin School Dataframe
#---------------------
Griffin_summary_table = pd.DataFrame({"School Name":Griffin_school_name,
                             "Type":[Griffin_school_type],
                             "Total Students":[Griffin_total_students],
                             "Budget":[Griffin_budget],
                             "Budget Per Student":[Griffin_budget_per_student],
                             "Average Math Score":[Griffin_ave_math],
                             "Average Reading Score":[Griffin_ave_read],
                             "% Passing Math":[math_pass_percentage],
                             "% Passing Reading":[read_pass_percentage],
                              "Overall Passing":[combined_pass]})

Griffin_summary_table = Griffin_summary_table[["School Name","Type","Total Students","Budget","Budget Per Student","Average Math Score","Average Reading Score","% Passing Math", "% Passing Reading", "Overall Passing"]]

Griffin_summary_table.head()
```


```python
#Creating a DF with Wilson school resetting index
#Wilson High School
Wilson_df = merged_df.loc[merged_df["school"]=="Wilson High School",:]
Wilson_df = Wilson_df.reset_index(drop=True)
Wilson_df.head()
```


```python
#Grabbing all Wilson high school info
Wilson_school_name = Wilson_df.iloc[0,1]
Wilson_school_type = Wilson_df.iloc[0,2]
Wilson_total_students = Wilson_df.iloc[0,3]
Wilson_budget = Wilson_df.iloc[0,4]
Wilson_budget_per_student = Wilson_budget / Wilson_total_students
Wilson_ave_math = Wilson_df['math_score'].mean()
Wilson_ave_read = Wilson_df['reading_score'].mean()

#Percent passing math at Wilson
#Looping to place a "p" in a list for each pass
math_passer= []
for row in Wilson_df['math_score']:
    if row >= 70:
        math_passer.append('p')
math_df=pd.DataFrame(math_passer)
x = len (math_df.index)
math_pass_percentage = x / Wilson_total_students

#Percent passing reading at Wilson
#Looping to place a "p" in a list for each pass
read_passer= []
for row in Wilson_df['reading_score']:
    if row >= 70:
        read_passer.append('p')
read_df=pd.DataFrame(read_passer)
x = len (read_df.index)
read_pass_percentage = x / Wilson_total_students

passers=read_pass_percentage + math_pass_percentage
combined_pass = passers / 2

#----------------------
#Wilson School Dataframe
#---------------------
Wilson_summary_table = pd.DataFrame({"School Name":Wilson_school_name,
                             "Type":[Wilson_school_type],
                             "Total Students":[Wilson_total_students],
                             "Budget":[Wilson_budget],
                             "Budget Per Student":[Wilson_budget_per_student],
                             "Average Math Score":[Wilson_ave_math],
                             "Average Reading Score":[Wilson_ave_read],
                             "% Passing Math":[math_pass_percentage],
                             "% Passing Reading":[read_pass_percentage],
                              "Overall Passing":[combined_pass]})

Wilson_summary_table = Wilson_summary_table[["School Name","Type","Total Students","Budget","Budget Per Student","Average Math Score","Average Reading Score","% Passing Math", "% Passing Reading", "Overall Passing"]]

Wilson_summary_table.head()
```


```python
#Creating a DF with Cabrera school resetting index
#Cabrera High School
Cabrera_df = merged_df.loc[merged_df["school"]=="Cabrera High School",:]
Cabrera_df = Cabrera_df.reset_index(drop=True)
Cabrera_df.head()
```


```python
#Grabbing all Cabrera high school info
Cabrera_school_name = Cabrera_df.iloc[0,1]
Cabrera_school_type = Cabrera_df.iloc[0,2]
Cabrera_total_students = Cabrera_df.iloc[0,3]
Cabrera_budget = Cabrera_df.iloc[0,4]
Cabrera_budget_per_student = Cabrera_budget / Cabrera_total_students
Cabrera_ave_math = Cabrera_df['math_score'].mean()
Cabrera_ave_read = Cabrera_df['reading_score'].mean()

#Percent passing math at Cabrera
#Looping to place a "p" in a list for each pass
math_passer= []
for row in Cabrera_df['math_score']:
    if row >= 70:
        math_passer.append('p')
math_df=pd.DataFrame(math_passer)
x = len (math_df.index)
math_pass_percentage = x / Cabrera_total_students

#Percent passing reading at Cabrera
#Looping to place a "p" in a list for each pass
read_passer= []
for row in Cabrera_df['reading_score']:
    if row >= 70:
        read_passer.append('p')
read_df=pd.DataFrame(read_passer)
x = len (read_df.index)
read_pass_percentage = x / Cabrera_total_students

passers=read_pass_percentage + math_pass_percentage
combined_pass = passers / 2

#----------------------
#Cabrera School Dataframe
#---------------------
Cabrera_summary_table = pd.DataFrame({"School Name":Cabrera_school_name,
                             "Type":[Cabrera_school_type],
                             "Total Students":[Cabrera_total_students],
                             "Budget":[Cabrera_budget],
                             "Budget Per Student":[Cabrera_budget_per_student],
                             "Average Math Score":[Cabrera_ave_math],
                             "Average Reading Score":[Cabrera_ave_read],
                             "% Passing Math":[math_pass_percentage],
                             "% Passing Reading":[read_pass_percentage],
                              "Overall Passing":[combined_pass]})

Cabrera_summary_table = Cabrera_summary_table[["School Name","Type","Total Students","Budget","Budget Per Student","Average Math Score","Average Reading Score","% Passing Math", "% Passing Reading", "Overall Passing"]]

Cabrera_summary_table.head()
```


```python
#Creating a DF with Bailey school resetting index
#Bailey High School
Bailey_df = merged_df.loc[merged_df["school"]=="Bailey High School",:]
Bailey_df = Bailey_df.reset_index(drop=True)
Bailey_df.head()
```


```python
#Grabbing all Bailey high school info
Bailey_school_name = Bailey_df.iloc[0,1]
Bailey_school_type = Bailey_df.iloc[0,2]
Bailey_total_students = Bailey_df.iloc[0,3]
Bailey_budget = Bailey_df.iloc[0,4]
Bailey_budget_per_student = Bailey_budget / Bailey_total_students
Bailey_ave_math = Bailey_df['math_score'].mean()
Bailey_ave_read = Bailey_df['reading_score'].mean()

#Percent passing math at Bailey
#Looping to place a "p" in a list for each pass
math_passer= []
for row in Bailey_df['math_score']:
    if row >= 70:
        math_passer.append('p')
math_df=pd.DataFrame(math_passer)
x = len (math_df.index)
math_pass_percentage = x / Bailey_total_students

#Percent passing reading at Bailey
#Looping to place a "p" in a list for each pass
read_passer= []
for row in Bailey_df['reading_score']:
    if row >= 70:
        read_passer.append('p')
read_df=pd.DataFrame(read_passer)
x = len (read_df.index)
read_pass_percentage = x / Bailey_total_students

passers=read_pass_percentage + math_pass_percentage
combined_pass = passers / 2

#----------------------
#Bailey School Dataframe
#---------------------
Bailey_summary_table = pd.DataFrame({"School Name":Bailey_school_name,
                             "Type":[Bailey_school_type],
                             "Total Students":[Bailey_total_students],
                             "Budget":[Bailey_budget],
                             "Budget Per Student":[Bailey_budget_per_student],
                             "Average Math Score":[Bailey_ave_math],
                             "Average Reading Score":[Bailey_ave_read],
                             "% Passing Math":[math_pass_percentage],
                             "% Passing Reading":[read_pass_percentage],
                              "Overall Passing":[combined_pass]})

Bailey_summary_table = Bailey_summary_table[["School Name","Type","Total Students","Budget","Budget Per Student","Average Math Score","Average Reading Score","% Passing Math", "% Passing Reading", "Overall Passing"]]

Bailey_summary_table.head()
```


```python
#Creating a DF with Holden school resetting index
#Holden High School
Holden_df = merged_df.loc[merged_df["school"]=="Holden High School",:]
Holden_df = Holden_df.reset_index(drop=True)
Holden_df.head()
```


```python
#Grabbing all Holden high school info
Holden_school_name = Holden_df.iloc[0,1]
Holden_school_type = Holden_df.iloc[0,2]
Holden_total_students = Holden_df.iloc[0,3]
Holden_budget = Holden_df.iloc[0,4]
Holden_budget_per_student = Holden_budget / Holden_total_students
Holden_ave_math = Holden_df['math_score'].mean()
Holden_ave_read = Holden_df['reading_score'].mean()

#Percent passing math at Holden
#Looping to place a "p" in a list for each pass
math_passer= []
for row in Holden_df['math_score']:
    if row >= 70:
        math_passer.append('p')
math_df=pd.DataFrame(math_passer)
x = len (math_df.index)
math_pass_percentage = x / Holden_total_students

#Percent passing reading at Holden
#Looping to place a "p" in a list for each pass
read_passer= []
for row in Holden_df['reading_score']:
    if row >= 70:
        read_passer.append('p')
read_df=pd.DataFrame(read_passer)
x = len (read_df.index)
read_pass_percentage = x / Holden_total_students

passers=read_pass_percentage + math_pass_percentage
combined_pass = passers / 2

#----------------------
#Holden School Dataframe
#---------------------
Holden_summary_table = pd.DataFrame({"School Name":Holden_school_name,
                             "Type":[Holden_school_type],
                             "Total Students":[Holden_total_students],
                             "Budget":[Holden_budget],
                             "Budget Per Student":[Holden_budget_per_student],
                             "Average Math Score":[Holden_ave_math],
                             "Average Reading Score":[Holden_ave_read],
                             "% Passing Math":[math_pass_percentage],
                             "% Passing Reading":[read_pass_percentage],
                              "Overall Passing":[combined_pass]})

Holden_summary_table = Holden_summary_table[["School Name","Type","Total Students","Budget","Budget Per Student","Average Math Score","Average Reading Score","% Passing Math", "% Passing Reading", "Overall Passing"]]

Holden_summary_table.head()
```


```python
#Creating a DF with Wright school resetting index
#Wright High School
Wright_df = merged_df.loc[merged_df["school"]=="Wright High School",:]
Wright_df = Wright_df.reset_index(drop=True)
Wright_df.head()
```


```python
#Grabbing all Wright high school info
Wright_school_name = Wright_df.iloc[0,1]
Wright_school_type = Wright_df.iloc[0,2]
Wright_total_students = Wright_df.iloc[0,3]
Wright_budget = Wright_df.iloc[0,4]
Wright_budget_per_student = Wright_budget / Wright_total_students
Wright_ave_math = Wright_df['math_score'].mean()
Wright_ave_read = Wright_df['reading_score'].mean()

#Percent passing math at Wright
#Looping to place a "p" in a list for each pass
math_passer= []
for row in Wright_df['math_score']:
    if row >= 70:
        math_passer.append('p')
math_df=pd.DataFrame(math_passer)
x = len (math_df.index)
math_pass_percentage = x / Wright_total_students

#Percent passing reading at Wright
#Looping to place a "p" in a list for each pass
read_passer= []
for row in Wright_df['reading_score']:
    if row >= 70:
        read_passer.append('p')
read_df=pd.DataFrame(read_passer)
x = len (read_df.index)
read_pass_percentage = x / Wright_total_students

passers=read_pass_percentage + math_pass_percentage
combined_pass = passers / 2

#----------------------
#Wright School Dataframe
#---------------------
Wright_summary_table = pd.DataFrame({"School Name":Wright_school_name,
                             "Type":[Wright_school_type],
                             "Total Students":[Wright_total_students],
                             "Budget":[Wright_budget],
                             "Budget Per Student":[Wright_budget_per_student],
                             "Average Math Score":[Wright_ave_math],
                             "Average Reading Score":[Wright_ave_read],
                             "% Passing Math":[math_pass_percentage],
                             "% Passing Reading":[read_pass_percentage],
                              "Overall Passing":[combined_pass]})

Wright_summary_table = Wright_summary_table[["School Name","Type","Total Students","Budget","Budget Per Student","Average Math Score","Average Reading Score","% Passing Math", "% Passing Reading", "Overall Passing"]]

Wright_summary_table.head()
```


```python
#Creating a DF with Rodriguez school resetting index
#Rodriguez High School
Rodriguez_df = merged_df.loc[merged_df["school"]=="Rodriguez High School",:]
Rodriguez_df = Rodriguez_df.reset_index(drop=True)
Rodriguez_df.head()
```


```python
#Grabbing all Rodriguez high school info
Rodriguez_school_name = Rodriguez_df.iloc[0,1]
Rodriguez_school_type = Rodriguez_df.iloc[0,2]
Rodriguez_total_students = Rodriguez_df.iloc[0,3]
Rodriguez_budget = Rodriguez_df.iloc[0,4]
Rodriguez_budget_per_student = Rodriguez_budget / Rodriguez_total_students
Rodriguez_ave_math = Rodriguez_df['math_score'].mean()
Rodriguez_ave_read = Rodriguez_df['reading_score'].mean()

#Percent passing math at Rodriguez
#Looping to place a "p" in a list for each pass
math_passer= []
for row in Rodriguez_df['math_score']:
    if row >= 70:
        math_passer.append('p')
math_df=pd.DataFrame(math_passer)
x = len (math_df.index)
math_pass_percentage = x / Rodriguez_total_students

#Percent passing reading at Rodriguez
#Looping to place a "p" in a list for each pass
read_passer= []
for row in Rodriguez_df['reading_score']:
    if row >= 70:
        read_passer.append('p')
read_df=pd.DataFrame(read_passer)
x = len (read_df.index)
read_pass_percentage = x / Rodriguez_total_students

passers=read_pass_percentage + math_pass_percentage
combined_pass = passers / 2

#----------------------
#Rodriguez School Dataframe
#---------------------
Rodriguez_summary_table = pd.DataFrame({"School Name":Rodriguez_school_name,
                             "Type":[Rodriguez_school_type],
                             "Total Students":[Rodriguez_total_students],
                             "Budget":[Rodriguez_budget],
                             "Budget Per Student":[Rodriguez_budget_per_student],
                             "Average Math Score":[Rodriguez_ave_math],
                             "Average Reading Score":[Rodriguez_ave_read],
                             "% Passing Math":[math_pass_percentage],
                             "% Passing Reading":[read_pass_percentage],
                              "Overall Passing":[combined_pass]})

Rodriguez_summary_table = Rodriguez_summary_table[["School Name","Type","Total Students","Budget","Budget Per Student","Average Math Score","Average Reading Score","% Passing Math", "% Passing Reading", "Overall Passing"]]

Rodriguez_summary_table.head()
```


```python
#Creating a DF with Johnson school resetting index
#Johnson High School
Johnson_df = merged_df.loc[merged_df["school"]=="Johnson High School",:]
Johnson_df = Johnson_df.reset_index(drop=True)
Johnson_df.head()
```


```python
#Grabbing all Johnson high school info
Johnson_school_name = Johnson_df.iloc[0,1]
Johnson_school_type = Johnson_df.iloc[0,2]
Johnson_total_students = Johnson_df.iloc[0,3]
Johnson_budget = Johnson_df.iloc[0,4]
Johnson_budget_per_student = Johnson_budget / Johnson_total_students
Johnson_ave_math = Johnson_df['math_score'].mean()
Johnson_ave_read = Johnson_df['reading_score'].mean()

#Percent passing math at Johnson
#Looping to place a "p" in a list for each pass
math_passer= []
for row in Johnson_df['math_score']:
    if row >= 70:
        math_passer.append('p')
math_df=pd.DataFrame(math_passer)
x = len (math_df.index)
math_pass_percentage = x / Johnson_total_students

#Percent passing reading at Johnson
#Looping to place a "p" in a list for each pass
read_passer= []
for row in Johnson_df['reading_score']:
    if row >= 70:
        read_passer.append('p')
read_df=pd.DataFrame(read_passer)
x = len (read_df.index)
read_pass_percentage = x / Johnson_total_students

passers=read_pass_percentage + math_pass_percentage
combined_pass = passers / 2

#----------------------
#Johnson School Dataframe
#---------------------
Johnson_summary_table = pd.DataFrame({"School Name":Johnson_school_name,
                             "Type":[Johnson_school_type],
                             "Total Students":[Johnson_total_students],
                             "Budget":[Johnson_budget],
                             "Budget Per Student":[Johnson_budget_per_student],
                             "Average Math Score":[Johnson_ave_math],
                             "Average Reading Score":[Johnson_ave_read],
                             "% Passing Math":[math_pass_percentage],
                             "% Passing Reading":[read_pass_percentage],
                              "Overall Passing":[combined_pass]})

Johnson_summary_table = Johnson_summary_table[["School Name","Type","Total Students","Budget","Budget Per Student","Average Math Score","Average Reading Score","% Passing Math", "% Passing Reading", "Overall Passing"]]

Johnson_summary_table.head()
```


```python
#Creating a DF with Ford school resetting index
#Ford High School
Ford_df = merged_df.loc[merged_df["school"]=="Ford High School",:]
Ford_df = Ford_df.reset_index(drop=True)
Ford_df.head()
```


```python
#Grabbing all Ford high school info
Ford_school_name = Ford_df.iloc[0,1]
Ford_school_type = Ford_df.iloc[0,2]
Ford_total_students = Ford_df.iloc[0,3]
Ford_budget = Ford_df.iloc[0,4]
Ford_budget_per_student = Ford_budget / Ford_total_students
Ford_ave_math = Ford_df['math_score'].mean()
Ford_ave_read = Ford_df['reading_score'].mean()

#Percent passing math at Ford
#Looping to place a "p" in a list for each pass
math_passer= []
for row in Ford_df['math_score']:
    if row >= 70:
        math_passer.append('p')
math_df=pd.DataFrame(math_passer)
x = len (math_df.index)
math_pass_percentage = x / Ford_total_students

#Percent passing reading at Ford
#Looping to place a "p" in a list for each pass
read_passer= []
for row in Ford_df['reading_score']:
    if row >= 70:
        read_passer.append('p')
read_df=pd.DataFrame(read_passer)
x = len (read_df.index)
read_pass_percentage = x / Ford_total_students

passers=read_pass_percentage + math_pass_percentage
combined_pass = passers / 2

#----------------------
#Ford School Dataframe
#---------------------
Ford_summary_table = pd.DataFrame({"School Name":Ford_school_name,
                             "Type":[Ford_school_type],
                             "Total Students":[Ford_total_students],
                             "Budget":[Ford_budget],
                             "Budget Per Student":[Ford_budget_per_student],
                             "Average Math Score":[Ford_ave_math],
                             "Average Reading Score":[Ford_ave_read],
                             "% Passing Math":[math_pass_percentage],
                             "% Passing Reading":[read_pass_percentage],
                              "Overall Passing":[combined_pass]})

Ford_summary_table = Ford_summary_table[["School Name","Type","Total Students","Budget","Budget Per Student","Average Math Score","Average Reading Score","% Passing Math", "% Passing Reading", "Overall Passing"]]

Ford_summary_table.head()
```


```python
#Creating a DF with Thomas school resetting index
#Thomas High School
Thomas_df = merged_df.loc[merged_df["school"]=="Thomas High School",:]
Thomas_df = Thomas_df.reset_index(drop=True)
Thomas_df.head()
```


```python
#Grabbing all Thomas high school info
Thomas_school_name = Thomas_df.iloc[0,1]
Thomas_school_type = Thomas_df.iloc[0,2]
Thomas_total_students = Thomas_df.iloc[0,3]
Thomas_budget = Thomas_df.iloc[0,4]
Thomas_budget_per_student = Thomas_budget / Thomas_total_students
Thomas_ave_math = Thomas_df['math_score'].mean()
Thomas_ave_read = Thomas_df['reading_score'].mean()

#Percent passing math at Thomas
#Looping to place a "p" in a list for each pass
math_passer= []
for row in Thomas_df['math_score']:
    if row >= 70:
        math_passer.append('p')
math_df=pd.DataFrame(math_passer)
x = len (math_df.index)
math_pass_percentage = x / Thomas_total_students

#Percent passing reading at Thomas
#Looping to place a "p" in a list for each pass
read_passer= []
for row in Thomas_df['reading_score']:
    if row >= 70:
        read_passer.append('p')
read_df=pd.DataFrame(read_passer)
x = len (read_df.index)
read_pass_percentage = x / Thomas_total_students

passers=read_pass_percentage + math_pass_percentage
combined_pass = passers / 2

#----------------------
#Thomas School Dataframe
#---------------------
Thomas_summary_table = pd.DataFrame({"School Name":Thomas_school_name,
                             "Type":[Thomas_school_type],
                             "Total Students":[Thomas_total_students],
                             "Budget":[Thomas_budget],
                             "Budget Per Student":[Thomas_budget_per_student],
                             "Average Math Score":[Thomas_ave_math],
                             "Average Reading Score":[Thomas_ave_read],
                             "% Passing Math":[math_pass_percentage],
                             "% Passing Reading":[read_pass_percentage],
                              "Overall Passing":[combined_pass]})

Thomas_summary_table = Thomas_summary_table[["School Name","Type","Total Students","Budget","Budget Per Student","Average Math Score","Average Reading Score","% Passing Math", "% Passing Reading", "Overall Passing"]]

Thomas_summary_table.head()
```


```python
#====================================
#School Summary
#====================================
School_Final_Summary=pd.concat([pena_summary_table,Figueroa_summary_table,huang_summary_table,Shelton_summary_table,Cabrera_summary_table,Hernandez_summary_table,Bailey_summary_table,Holden_summary_table,Wright_summary_table,Johnson_summary_table,Ford_summary_table,Thomas_summary_table,Griffin_summary_table,Wilson_summary_table,Rodriguez_summary_table], axis=0)   
School_Final_Summary = School_Final_Summary.sort_values("Overall Passing", ascending=False)
School_Final_Summary = School_Final_Summary.reset_index(drop=True)
School_Final_Summary
```


```python
School_Final_Summary.to_excel("Output/School Summary.xlsx", index=False, header=True)
```


```python
#Top Schools by Passing Rate
Top_Schools = School_Final_Summary.iloc[0:5,0:10]
Top_Schools.head()
```


```python
#Exporting top passing rate
Top_Schools.to_excel("Output/Top Passing Rate.xlsx", index=False, header=True)
```


```python
#-----------------------------------
#Bottom Schools by Passing Rate
#-----------------------------------
Bottom_Schools = School_Final_Summary.iloc[10:15,0:10]
Bottom_Schools.head()
```


```python
#Exporting Bottom Passing Rate
Bottom_Schools.to_excel("Output/Bottom Passing Rate.xlsx", index=False, header=True)
```


```python
#--------------------------------------
#Working on scores per grade break down
#-----------------------------------------
#looking at the number of grades listed in the data set
school_df['school'].unique
```


```python
#Getting Math and Reading Averages by grade and placing them into a DF
#Huang averages per grade
huang_group=huang_df.groupby(['grade'], as_index=False).mean()[['grade','reading_score','math_score']]
huang_group["school"] = 'Huang High School'
huang_group = huang_group [['school','grade','reading_score','math_score']]
huang_group["school"] = 'Huang High School'
huang_group.head()
```


```python
#Getting Math and Reading Averages by grade and placing them into a DF
#Figueroa averages per grade
Figueroa_group=Figueroa_df.groupby(['grade'], as_index=False).mean()[['grade','reading_score','math_score']]
Figueroa_group["school"] = 'Figueroa High School'
Figueroa_group = Figueroa_group [['school','grade','reading_score','math_score']]
Figueroa_group["school"] = 'Figueroa High School'
Figueroa_group.head()
```


```python
#Getting Math and Reading Averages by grade and placing them into a DF
#Shelton averages per grade
Shelton_group=Shelton_df.groupby(['grade'], as_index=False).mean()[['grade','reading_score','math_score']]
Shelton_group["school"] = 'Shelton High School'
Shelton_group = Shelton_group [['school','grade','reading_score','math_score']]
Shelton_group["school"] = 'Shelton High School'
Shelton_group.head()
```


```python
#Getting Math and Reading Averages by grade and placing them into a DF
#Hernandez averages per grade
Hernandez_group=Hernandez_df.groupby(['grade'], as_index=False).mean()[['grade','reading_score','math_score']]
Hernandez_group["school"] = 'Hernandez High School'
Hernandez_group = Hernandez_group [['school','grade','reading_score','math_score']]
Hernandez_group["school"] = 'Hernandez High School'
Hernandez_group.head()
```


```python
#Getting Math and Reading Averages by grade and placing them into a DF
#Griffin averages per grade
Griffin_group=Griffin_df.groupby(['grade'], as_index=False).mean()[['grade','reading_score','math_score']]
Griffin_group["school"] = 'Griffin High School'
Griffin_group = Griffin_group [['school','grade','reading_score','math_score']]
Griffin_group["school"] = 'Griffin High School'
Griffin_group.head()
```


```python
#Getting Math and Reading Averages by grade and placing them into a DF
#Wilson averages per grade
Wilson_group=Wilson_df.groupby(['grade'], as_index=False).mean()[['grade','reading_score','math_score']]
Wilson_group["school"] = 'Wilson High School'
Wilson_group = Wilson_group [['school','grade','reading_score','math_score']]
Wilson_group["school"] = 'Wilson High School'
Wilson_group.head()
```


```python
#Getting Math and Reading Averages by grade and placing them into a DF
#Cabrera averages per grade
Cabrera_group=Cabrera_df.groupby(['grade'], as_index=False).mean()[['grade','reading_score','math_score']]
Cabrera_group["school"] = 'Cabrera High School'
Cabrera_group = Cabrera_group [['school','grade','reading_score','math_score']]
Cabrera_group["school"] = 'Cabrera High School'
Cabrera_group.head()

```


```python
#Getting Math and Reading Averages by grade and placing them into a DF
#Bailey averages per grade
Bailey_group=Bailey_df.groupby(['grade'], as_index=False).mean()[['grade','reading_score','math_score']]
Bailey_group["school"] = 'Bailey High School'
Bailey_group = Bailey_group [['school','grade','reading_score','math_score']]
Bailey_group["school"] = 'Bailey High School'
Bailey_group.head()
```


```python
#Getting Math and Reading Averages by grade and placing them into a DF
#Holden averages per grade
Holden_group=Holden_df.groupby(['grade'], as_index=False).mean()[['grade','reading_score','math_score']]
Holden_group["school"] = 'Holden High School'
Holden_group = Holden_group [['school','grade','reading_score','math_score']]
Holden_group["school"] = 'Holden High School'
Holden_group.head()
```


```python
#Getting Math and Reading Averages by grade and placing them into a DF
#Pena averages per grade
Pena_group=pena_df.groupby(['grade'], as_index=False).mean()[['grade','reading_score','math_score']]
Pena_group["school"] = 'Pena High School'
Pena_group = Pena_group [['school','grade','reading_score','math_score']]
Pena_group["school"] = 'Pena High School'
Pena_group.head()
```


```python
#Getting Math and Reading Averages by grade and placing them into a DF
#Wright averages per grade
Wright_group=Wright_df.groupby(['grade'], as_index=False).mean()[['grade','reading_score','math_score']]
Wright_group["school"] = 'Wright High School'
Wright_group = Wright_group [['school','grade','reading_score','math_score']]
Wright_group["school"] = 'Wright High School'
Wright_group.head()
```


```python
#Getting Math and Reading Averages by grade and placing them into a DF
#Rodriguez averages per grade
Rodriguez_group=Rodriguez_df.groupby(['grade'], as_index=False).mean()[['grade','reading_score','math_score']]
Rodriguez_group["school"] = 'Rodriguez High School'
Rodriguez_group = Rodriguez_group [['school','grade','reading_score','math_score']]
Rodriguez_group["school"] = 'Rodriguez High School'
Rodriguez_group.head()
```


```python
#Getting Math and Reading Averages by grade and placing them into a DF
#Johnson averages per grade
Johnson_group=Johnson_df.groupby(['grade'], as_index=False).mean()[['grade','reading_score','math_score']]
Johnson_group["school"] = 'Johnson High School'
Johnson_group = Johnson_group [['school','grade','reading_score','math_score']]
Johnson_group["school"] = 'Johnson High School'
Johnson_group.head()
```


```python
#Getting Math and Reading Averages by grade and placing them into a DF
#Ford averages per grade
Ford_group=Ford_df.groupby(['grade'], as_index=False).mean()[['grade','reading_score','math_score']]
Ford_group["school"] = 'Ford High School'
Ford_group = Ford_group [['school','grade','reading_score','math_score']]
Ford_group["school"] = 'Ford High School'
Ford_group.head()
```


```python
#Getting Math and Reading Averages by grade and placing them into a DF
#Thomas averages per grade
Thomas_group=Thomas_df.groupby(['grade'], as_index=False).mean()[['grade','reading_score','math_score']]
Thomas_group["school"] = 'Thomas High School'
Thomas_group = Thomas_group [['school','grade','reading_score','math_score']]
Thomas_group["school"] = 'Thomas High School'
Thomas_group.head()
```


```python
#-----------------------------------------
#Average scores by grade for each school
#-----------------------------------------
Grade_Summary=pd.concat([Pena_group,Figueroa_group,huang_group,Shelton_group,Cabrera_group,Hernandez_group,Bailey_group,Holden_group,Wright_group,Johnson_group,Ford_group,Thomas_group,Griffin_group,Wilson_group,Rodriguez_group], axis=0)   
Grade_Summary.head(20)
```


```python
Grade_Summary.to_excel("Output/Scores By Grade.xlsx", index=False, header=True)
```


```python
#Scores by School Spending
School_Final_Summary.head()
```


```python
Budget_Breakdown = School_Final_Summary
Budget_Breakdown.head(15)
```


```python
#Creating Bins for school spending
bins = [0,584,626,645,656]

# Create the names for the four bins
group_names = ['Low Budget', 'Mid Budget', 'Good Budget', 'Great Budget']

#Assigning to column the bins will look at
pd.cut(Budget_Breakdown["Budget Per Student"], bins, labels=group_names)
```


```python
#Placing the bins into a column of their own
Budget_Breakdown["Budget Bin"] = pd.cut(Budget_Breakdown["Budget Per Student"], bins, labels=group_names)
Budget_Breakdown.head(10)
```


```python
#-=================================
#Budget Breakdown
#=================================
Budget_Breakdown=Budget_Breakdown.groupby(['Budget Bin'], as_index=False).mean()[['Budget Bin','Average Math Score','Average Reading Score',"% Passing Math","% Passing Reading","Overall Passing"]]
Budget_Breakdown.head()
```


```python
Budget_Breakdown.to_excel("Output/Budget Summary.xlsx", index=False, header=True)
```


```python
Size_Breakdown = School_Final_Summary
Size_Breakdown.head()
```


```python
#Creating Bins for school spending
bins = [0,1801,3001,5001]

# Create the names for the four bins
group_names = ['Small School', 'Medium School', 'Large School']

#Assigning to column the bins will look at
pd.cut(Size_Breakdown["Total Students"], bins, labels=group_names)
```


```python
#Placing the bins into a column of their own
Size_Breakdown["Size Bin"] = pd.cut(Size_Breakdown["Total Students"], bins, labels=group_names)
Size_Breakdown.head(10)
```


```python
#-=================================
#Size Breakdown
#groups by Size Column, then places in DF
#=================================
Size_Breakdown=Size_Breakdown.groupby(['Size Bin'], as_index=False).mean()[['Size Bin','Average Math Score','Average Reading Score',"% Passing Math","% Passing Reading","Overall Passing"]]
Size_Breakdown.head()
```


```python
Size_Breakdown.to_excel("Output/School Size Summary.xlsx", index=False, header=True)
```


```python
#-=================================
#Type Breakdown
#=================================
Type_Breakdown=School_Final_Summary.groupby(['Type'], as_index=False).mean()[['Type','Average Math Score','Average Reading Score',"% Passing Math","% Passing Reading","Overall Passing"]]
Type_Breakdown.head()
```


```python
Type_Breakdown.to_excel("Output/School Type Summary.xlsx", index=False, header=True)
```


```python
#Completed, please check output folder for key info.
```
