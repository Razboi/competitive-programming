public class ReverseOrRotate {

    // https://www.codewars.com/kata/56b5afb4ed1f6d5fb0000991/train/java

    public static void main(String[] args) {
        System.out.println(revRot("66443875", 4));
    }

    public static String revRot(String strng, int sz) {
        if (sz <= 0 || strng.isEmpty() || sz > strng.length()) {
            return "";
        }
        String chunks = "";

        for (int i = 0; i < (strng.length() / sz); i++) {
            String chunk = strng.substring(i * sz, (i + 1) * sz);
            if (chunk.length() >= sz - 1) {
                chunk = applyTransformations(chunk);
                chunks += chunk;
            }
        }
        return chunks;
    }

    private static String applyTransformations(String chunk) {
        int sum = 0;
        for (int i = 0; i < chunk.length(); i++) {
            int digit = chunk.charAt(i);
            sum += digit * digit;
        }
        if (sum % 2 == 0) {
            return reverseChunk(chunk);
        }
        return rotateChunkLeft(chunk);
    }

    private static String reverseChunk(String chunk) {
        char[] reversed = new char[chunk.length()];
        for (int i = 0; i < chunk.length(); i++) {
            reversed[i] = chunk.charAt(chunk.length() - i - 1);
        }
        return new String(reversed);
    }

    private static String rotateChunkLeft(String chunk) {
        char[] rotated = new char[chunk.length()];
        rotated[chunk.length() - 1] = chunk.charAt(0);
        for (int i = 1; i < chunk.length(); i++) {
            rotated[i - 1] = chunk.charAt(i);
        }
        return new String(rotated);
    }
}
