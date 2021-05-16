import pandas
   
data = {
    "username" : ['admin','Charles','Deku' ],
    "password" : ['password','Charl13','Allmight']
}

dataframe = pandas.DataFrame(data)

print (dataframe)

dataframe.to_csv("sample.csv", index=False)
