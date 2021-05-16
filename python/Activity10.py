num_tuple  = tuple  (input("Enter the numbers to be added separated by commma : ").split(", "))
#num_tuple = (10, 3, 34, 45)
print("tuple values are :", num_tuple)
print ("Numbers divisible by 5 are ")
for  n in num_tuple:
    if (int (n) %5 == 0):
        print( n )
