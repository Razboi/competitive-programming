"""
Write an algorith such that if an element in an M x N matrix is 0,
its entire row and columns are set to 0
"""

def empty_rows(matrix, num_cols, num_rows):
    for row_index in range(1, num_rows):
        if matrix[row_index][0] == 0:
            for col_index in range(1, num_cols):
                matrix[row_index][col_index] = 0


def empty_cols(matrix, num_cols, num_rows):
    for col_index in range(1, num_cols):
        if matrix[0][col_index] == 0:
            for row_index in range(1, num_rows):
                matrix[row_index][col_index] = 0


def check_first_row_has_zeros(matrix, num_cols):
    for col_index in range(0, num_cols):
        if matrix[0][col_index] == 0:
            return True
    return False


def check_first_col_has_zeros(matrix, num_rows):
    for row_index in range(0, num_rows):
        if matrix[row_index][0] == 0:
            return True
    return False


def empty_first_row(matrix, num_cols):
    for col_index in range(0, num_cols):
        matrix[0][col_index] = 0


def empty_first_col(matrix, num_rows):
    for row_index in range(0, num_rows):
        matrix[row_index][0] = 0


# time complexity: O(n²), space complexity: O(1)
def zero_matrix(matrix):
    num_rows = len(matrix)
    num_cols = len(matrix[0])
    first_row_has_zeros = check_first_row_has_zeros(matrix, num_cols)
    first_col_has_zeros = check_first_col_has_zeros(matrix, num_rows)

    for row_index in range(0, num_rows):
        for col_index in range(0, num_cols):
            if matrix[row_index][col_index] == 0:
                matrix[row_index][0] = 0
                matrix[0][col_index] = 0

    empty_rows(matrix, num_cols, num_rows)
    empty_cols(matrix, num_cols, num_rows)
    if first_row_has_zeros:
        empty_first_row(matrix, num_cols)
    if first_col_has_zeros:
        empty_first_col(matrix, num_rows)

test = [[1,3,0,2],[3,5,6,3],[1,2,1,0],[3,4,7,1]]
zero_matrix(test)
print(test)
