"""
There are three types of edits that can be performed on strings: insert a character, remove a character or replace a character.
Given two strings, write a function to check if they are one edit (or zero edits) away
"""

def is_one_away_same_length(str1, str2):
    foundDifference = False
    for i in range(len(str1)):
        if str1[i] != str2[i]:
            if foundDifference:
                return False
            foundDifference = True

    return True


def is_one_away_different_length(longest, shortest):
    foundDifference = False
    longestIndex = 0
    shortestIndex = 0

    while shortestIndex < len(shortest):
        if longest[longestIndex] != shortest[shortestIndex]:
            if foundDifference:
                return False
            foundDifference = True
        else:
            shortestIndex += 1
        longestIndex += 1

    return True


# time complexity: O(n), space complexity: O(1)
def is_one_away(str1, str2):
    lengthDifference = abs(len(str1) - len(str2))
    if lengthDifference == 0:
        return is_one_away_same_length(str1, str2)
    elif lengthDifference == 1:
        return is_one_away_different_length(str1, str2) if len(str1) > len(str2) else is_one_away_different_length(str2, str1)
    else:
        return False


print(is_one_away("pale", "ple"));
print(is_one_away("pales", "pale"));
print(is_one_away("pale", "bale"));
print(is_one_away("pale", "bake"));
