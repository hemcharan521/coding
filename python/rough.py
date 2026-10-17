import csv
file_path = "C:/Users/hemch/OneDrive/Desktop/pythontesting/output.csv"
try :
   with open(file_path,"r") as file:
      content = csv.reader(file)
      for line in content:
           if line:
             print(line)
     
except FileNotFoundError:
         print("enter valid path")