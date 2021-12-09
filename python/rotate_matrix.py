import math

"""
Given an image represented by an N x N matrix, where each pixel in the image is represented
by an integer, write a method to rotate the image by 90 degrees. Do it in place.
"""

# time complexity: O(n²), space complexity: O(1)
def rotate_matrix(matrix):
    if len(matrix) <= 1 or len(matrix) != len(matrix[0]):
        return False

    for layer in range(len(matrix) // 2):
        last = len(matrix) - layer - 1
        for i in range(layer, last):
            top = matrix[layer][i]
            # top <- left
            matrix[layer][i] = matrix[len(matrix) - 1 - i][layer]
            # left <- bottom
            matrix[len(matrix) - 1 - i][layer] = matrix[last][len(matrix) - 1 - i]
            # bottom <- right
            matrix[last][len(matrix) - 1 - i] = matrix[i][last]
            # right <- top
            matrix[i][last] = top

    return True

test = [[1,3,0,2],[3,5,6,3],[1,2,1,0],[3,4,7,1]]
rotate_matrix(test)
print(test)
