
#print("There once was a man named George, ")
#print("he was 70 years old. ")
#print("He really liked the name George, ")
#print("but didn't like being 70.")

# that is an story in which we observe a name and an age.
# if we wanted to change either, instead of doing
# it manually all the time
# let's do it with variables.

character_name = "John"
character_age = "35"
# common practice is to name variables with underscores, all lower case

print("There once was a man named "+character_name+", ")
print("he was "+character_age+" years old. ")
print("He really liked the name "+character_name+", ")
print("but didn't like being "+character_age+".")

#those variables are both strings
#which are pure text
#there are other types, like numbers and booleans
#just to clarify, since we dont need to predefine the data type of
#the variables, all numbers are the same (sort of, that's a lie)

character_age = 50
is_male = False

#for strings, you should know some stuff, like
# \n is a blank space
# \ is an escape character, for example if you want to print quotes
#like so print("I \"guess\" that is right")
#there are methods accesible with the dot
#like string.lower(), which transforms the string into full lower case
#these methods are concatenable, like string.upper().isUpper()
#which always returns a True
#strings are considered lists of characters, so you can access
#certain characters with the []
#like so string[0] gives me the first character
