public class RecreationOne {
    //https://www.codewars.com/kata/55aa075506463dac6600010d/train/java

    public static void main(String[] args) {
        System.out.println(listSquared(1, 1));
    }

    public static String listSquared(long m, long n) {
        StringBuilder results = new StringBuilder("[");
        while (m < n) {
            long sumOfSquaredDivisors = getSumOfSquaredDivisors(m);
            if (isSquare(sumOfSquaredDivisors)) {
                results.append(String.format("[%d, %d], ", m, sumOfSquaredDivisors));
            }
            m++;
        }
        int index = results.lastIndexOf(",");
        if (index == -1) {
            results.append("]");
        } else {
            results.replace(index, index + 2, "]");
        }
        return results.toString();
    }

    private static boolean isSquare(Long number) {
        for (int i = 1; i * i <= number; i++) {
            if (i * i == number) {
                return true;
            }
        }
        return false;
    }

    private static long getSumOfSquaredDivisors(long number) {
        long sumOfSquaredDivisors = 0;
        for (long i = 1; i <= number; i++) {
            if (number % i == 0) {
                sumOfSquaredDivisors += i * i;
            }
        }
        return sumOfSquaredDivisors;
    }
}
