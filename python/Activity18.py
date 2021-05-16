import pandas

dataframe = pandas.read_csv("sample.csv")

# Print the values only in the Usernames column
print("Full Data")
print(dataframe['username'])

# Print the username and password of the second row
print ("---------------")
print("username : " , dataframe['username'][1] ,"|", "password",dataframe['password'][1] )

#Sort the Usernames column data in ascending order and print data
print ("---------------")
print("Data sorted in ascending Usernames:")
print(dataframe.sort_values('username'))

#Sort the Passwords column in descending order and print data
print ("---------------")
print("Data sorted in descending Passwords:")
print(dataframe.sort_values('password', ascending = False))
