public class ProductOfConsecutiveFibNumbers {

    // https://www.codewars.com/kata/5541f58a944b85ce6d00006a/train/java

    public static void main(String[] args) {
        productFib(714);
    }

    public static long[] productFib(long prod) {
        return calculateFibonacci(0, 1, prod);
    }

    private static long[] calculateFibonacci(long n1, long n2, long prod) {
        long result = n1 * n2;
        if (result == prod) {
            return new long[]{n1, n2, 1};
        }
        if (result > prod) {
            return new long[]{n1, n2, 0};
        }
        return calculateFibonacci(n2, (n1 + n2), prod);
    }
}

