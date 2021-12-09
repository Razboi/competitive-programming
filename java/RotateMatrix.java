import java.util.Arrays;

// Given an image represented by an N x N matrix, where each pixel in the image is represented
// by an integer, write a method to rotate the image by 90 degrees. Do it in place.
class RotateMatrix {
    public static void main(String args[]) {
        int test[][] = {{1,3,0,2},{3,5,6,3},{1,2,1,0},{3,4,7,1}};
        rotateMatrixInPlace(test);
        System.out.println(Arrays.deepToString(test));
    }

    // time complexity: O(n²), space complexity: O(n)
    private static int[][] rotateMatrix(int matrix[][]) {
        if (matrix.length <= 1) return matrix;
        int newMatrix[][] = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                newMatrix[matrix.length - (1 + j)][i] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    // time complexity: O(n²), space complexity: O(1)
    private static boolean rotateMatrixInPlace(int matrix[][]) {
        if (matrix.length <= 1 || matrix.length != matrix[0].length) {
            return false;
        }
        for (int layer = 0; layer < matrix.length / 2; layer++) {
            int last = matrix.length - 1 - layer;
            for (int i = layer; i < last; i++) {
                int top = matrix[layer][i];
                // top <- left
                matrix[layer][i] = matrix[matrix.length - 1 - i][layer];
                // left <- bottom
                matrix[matrix.length - 1 - i][layer] = matrix[last][matrix.length - 1 - i];
                // bottom <- right
                matrix[last][matrix.length - 1 - i] = matrix[i][last];
                // right <- top
                matrix[i][last] = top;
            }
        }
        return true;
    }
}
