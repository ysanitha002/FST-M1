add_list  = list (input("Enter the numbers to be added separated by commma : ").split(", "))
print ("Given list is ", add_list)
if(add_list[0]==add_list[-1]):
    print("First and last element of the list are same")
else:
    print ("First and last element of the list are not same")

