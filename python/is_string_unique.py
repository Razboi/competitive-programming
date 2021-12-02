"""Implement an algorith to determine if a string has all unique characters"""

CHARSET_LENGTH = 128

# time complexity O(n), space complexity O(c) being c the charset length
def is_string_unique(string):
    if len(string) > CHARSET_LENGTH:
        return false

    chars_dic = {}
    for char in string:
        if char in chars_dic:
            return False
        chars_dic[char] = True

    return True


# time complexity O(n logn), space complexity O(c) being c the charset length
"""What if you cannot use additional data structures?"""
def is_string_unique_2(string):
    if len(string) > CHARSET_LENGTH:
        return false

    sorted_string = ''.join(sorted(string))
    for index, char in enumerate(sorted_string[:-1]):
        next_char = sorted_string[index + 1]
        if char == next_char:
            return False

    return True

