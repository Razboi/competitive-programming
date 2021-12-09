import java.util.Arrays;

// Write an algorith such that if an element in an M x N matrix is 0,
// its entire row and columns are set to 0

class ZeroMatrix {
    public static void main(String args[]) {
        int test[][] = {{1,3,0,2},{3,5,6,3},{1,2,1,0},{3,4,7,1}};
        zeroMatrix(test);
        System.out.println(Arrays.deepToString(test));
    }

    private static void emptyRows(int matrix[][], int numCols, int numRows) {
        for (int rowIndex = 1; rowIndex < numRows; rowIndex++) {
            if (matrix[rowIndex][0] == 0) {
                for (int colIndex = 1; colIndex < numCols; colIndex++) {
                    matrix[rowIndex][colIndex] = 0;
                }
            }
        }
    }

    private static void emptyCols(int matrix[][], int numCols, int numRows) {
        for (int colIndex = 1; colIndex < numCols; colIndex++) {
            if (matrix[0][colIndex] == 0) {
                for (int rowIndex = 1; rowIndex < numRows; rowIndex++) {
                    matrix[rowIndex][colIndex] = 0;
                }
            }
        }
    }

    private static boolean checkFirstRowHasZeros(int matrix[][], int numCols) {
        for (int colIndex = 0; colIndex < numCols; colIndex++) {
            if (matrix[0][colIndex] == 0) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkFirstColHasZeros(int matrix[][], int numRows) {
        for (int rowIndex = 0; rowIndex < numRows; rowIndex++) {
            if (matrix[rowIndex][0] == 0) {
                return true;
            }
        }
        return false;
    }

    private static void emptyFirstRow(int matrix[][], int numCols) {
        for (int colIndex = 0; colIndex < numCols; colIndex++) {
            matrix[0][colIndex] = 0;
        }
    }

    private static void emptyFirstCol(int matrix[][], int numRows) {
        for (int rowIndex = 0; rowIndex < numRows; rowIndex++) {
            matrix[rowIndex][0] = 0;
        }
    }


    // time complexity: O(n²), space complexity: O(1)
    private static void zeroMatrix(int matrix[][]) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        boolean firstRowHasZeros = checkFirstRowHasZeros(matrix, numCols);
        boolean firstColHasZeros = checkFirstColHasZeros(matrix, numRows);

        for (int rowIndex = 0; rowIndex < numRows; rowIndex++) {
            for (int colIndex = 0; colIndex < numCols; colIndex++) {
                if (matrix[rowIndex][colIndex] == 0) {
                    matrix[rowIndex][0] = 0;
                    matrix[0][colIndex] = 0;
                }
            }
        }
        emptyRows(matrix, numCols, numRows);
        emptyCols(matrix, numCols, numRows);
        if (firstRowHasZeros) {
            emptyFirstRow(matrix, numCols);
        }
        if (firstColHasZeros) {
            emptyFirstCol(matrix, numRows);
        }
    }
}
