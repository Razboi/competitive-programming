public class PyramidSlideDown {
    // https://www.codewars.com/kata/551f23362ff852e2ab000037/train/java

    public static void main(String[] args) {
        int[][] test = new int[][]{{75},
                {95, 64},
                {17, 47, 82},
                {18, 35, 87, 10},
                {20, 4, 82, 47, 65},
                {19, 1, 23, 75, 3, 34},
                {88, 2, 77, 73, 7, 63, 67},
                {99, 65, 4, 28, 6, 16, 70, 92},
                {41, 41, 26, 56, 83, 40, 80, 70, 33},
                {41, 48, 72, 33, 47, 32, 37, 16, 94, 29},
                {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14},
                {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57},
                {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48},
                {63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
                {4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23},
        };
        System.out.println(longestSlideDown(test));
    }

    public static int longestSlideDown(int[][] pyramid) {
        // TODO: DYNAMIC PROGRAMMING
        int sum = pyramid[0][0];
        int previousNodeIndex = 0;
        for (int i = 1; i < pyramid.length; i++) {
            int[] row = pyramid[i];
            int leftNode = row[previousNodeIndex];
            int rightNode = row[previousNodeIndex + 1];
            if (i != pyramid.length - 1) {
                int[] nextRow = pyramid[i + 1];
                int leftChildNode = nextRow[previousNodeIndex];
                int middleChildNode = nextRow[previousNodeIndex + 1];
                int rightChildNode = nextRow[previousNodeIndex + 2];
                int leftPathSum = leftNode + leftChildNode;
                int leftMiddlePathSum = leftNode + middleChildNode;
                int rightMiddlePathSum = rightNode + middleChildNode;
                int rightPathSum = rightNode + rightChildNode;
                if (leftPathSum > rightPathSum && leftPathSum > rightMiddlePathSum || leftMiddlePathSum > rightPathSum && leftMiddlePathSum > rightMiddlePathSum) {
                    sum += leftNode;
                } else {
                    sum += rightNode;
                    previousNodeIndex = previousNodeIndex + 1;
                }
            } else {
                sum += Math.max(leftNode, rightNode);
            }
        }
        return sum;
    }
}
