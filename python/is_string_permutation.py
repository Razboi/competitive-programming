"""Given two strings, write a method to decide if one is a permutation of the other"""
def sum_string_charcodes(string):
    sum = 0
    for char in string:
        sum += ord(char)
    return sum

# time complexity: O(n), space complexity(1)
def is_string_permutation(original, target):
    if len(original) != len(target):
        return False
    original_sum = sum_string_charcodes(original)
    target_sum = sum_string_charcodes(target)
    return original_sum == target_sum

print(is_string_permutation("test", "estt"))
print(is_string_permutation("test", "estT"))
print(is_string_permutation("test", "estt "))
print(is_string_permutation("test", "esttt"))
print(is_string_permutation("test", "supp"))
