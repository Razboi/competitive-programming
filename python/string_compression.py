"""
Implement a method to perform basic string compression using the counts of
repeated characters.
"""

# time complexity: O(n), space complexity: O(n)
def string_compression(string):
    if len(string) <= 2:
        return string

    compressed_strings = []
    repetitions_count = 0

    for i in range(len(string)):
        repetitions_count += 1
        if i == len(string) - 1 or string[i] != string[i + 1]:
            compressed_strings.append("%s%d" % (string[i], repetitions_count))
            repetitions_count = 0

    result = "".join(compressed_strings)
    return result if len(result) < len(string) else string


print(string_compression("aabcccccaaa"))
