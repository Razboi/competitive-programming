#Given a string, write a function to check if it is a permutation of a palindrome.
def get_char_to_count_map(str):
    charToCount = {}
    for char in str:
        if char == ' ':
            continue
        elif char in charToCount:
            charToCount[char] = charToCount[char] + 1
        else:
            charToCount[char] = 1
    return charToCount

# time complexity: O(n), space complexity: O(n)
def is_palindrome_permutation(str):
    charToCount = get_char_to_count_map(str)
    hasFoundOddCount = False
    for char, count in charToCount.items():
        if count % 2 != 0:
            if hasFoundOddCount:
                return False
            hasFoundOddCount = True

    return True


print(is_palindrome_permutation("tenet"))
print(is_palindrome_permutation("teent"))
print(is_palindrome_permutation("tteen"))
print(is_palindrome_permutation("teneta"))
print(is_palindrome_permutation("te net "))
