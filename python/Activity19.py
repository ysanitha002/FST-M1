import pandas
from pandas import ExcelWriter
   
data = {
    "FirstName" : ['Satvik','Avinash','Lahri'],
    "LastName" : ['Shah','Kati','Rath'],
    'Email': ["satshah@example.com", "avinashK@example.com", "lahri.rath@example.com"],
	'PhoneNumber': ["4537829158", "4892184058", "4528727830"]
}

dataframe = pandas.DataFrame(data)

# Print the dataframe
print(dataframe)
 
# Write the dataframe to a Excel file
writer = ExcelWriter('sample.xlsx')
dataframe.to_excel(writer, 'Sheet1', index = False)
 
# Commit data to the Excel file
writer.save()