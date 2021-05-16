'''List Sum Calculator
This is multiple line comment '''

add_list  = list (input("Enter the numbers to be added separated by commma : ").split(", "))
print (add_list)
sum=0
for n in add_list:
    sum += int (n)
print("sum of the list of elements is :", sum)

