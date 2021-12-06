""" Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space
at the end to hold the additional characters, and that you are given the "true" length of the string.
"""

def urlify(string):
    return string.strip().replace(' ', "%20");

print(urlify("tes t   "));
print(urlify(" t es t   "));
print(urlify("test"));
