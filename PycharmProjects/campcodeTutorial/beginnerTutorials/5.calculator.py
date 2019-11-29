#num1 = input("Enter a number: ")
#num2 = input("Enter another number: ")
#esult = num1 + num2
#print(result)

#this actually prints the concatenation of num1 and num2 as strings
#since python treats all input as a string.
#in order to transform those data types into numbers
#we should use int(string)
#like this

#num1 = input("Enter a number: ")
#num2 = input("Enter another number: ")
#result = int(num1) + int(num2)
#print(result)

#but that only works for integer numbers
#if we wanted to add functionality for decimal numbers
#we can use float(string)
#like so

num1 = input("Enter a number: ")
num2 = input("Enter another number: ")
result = float(num1) + float(num2)
print(result)