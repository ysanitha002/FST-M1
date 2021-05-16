import pandas

dataframe = pandas.read_excel("sample.xlsx","Sheet1")

# Print the values read from excel
print("Full Data")
print(dataframe)

#Print the number of rows and columns
print("=================================")
print("no of rows and columns in excel is : ", dataframe.shape)

#Print the data in the emails column only
print("=============Print only Email Column ====================")
print(dataframe['Email'])

#Sort the data based on FirstName in ascending order and print the data
print("\n=============Print ascendening order of First Name ====================")
print(dataframe.sort_values('FirstName',ascending=True))

