public class TripleTrouble {

    public static void main(String[] args) {
        System.out.println(TripleDouble(451909888277L, 41177722899L));
    }

    public static int TripleDouble(long num1, long num2) {
        String num1String = String.valueOf(num1);
        String num2String = String.valueOf(num2);

        for (int i = 0; i < 10; i++) {
            String digit = String.valueOf(i);
            if (num1String.contains(digit + digit + digit) && num2String.contains(digit + digit)) {
                return 1;
            }
        }
        return 0;
    }
}
