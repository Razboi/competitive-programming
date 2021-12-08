/*
Implement a method to perform basic string compression using the counts of
repeated characters.
*/

class StringCompression {
    public static void main(String args[]) {
        System.out.println(compressString("aabcccccaaa"));
    }

    // time complexity: O(n), space complexity: O(n)
    private static String compressString(String str) {
        if (str.length() <= 2) {
            return str;
        }
        StringBuilder resultBuilder = new StringBuilder();
        int charRepetitions = 0;

        for (int i = 0; i < str.length(); i++) {
            charRepetitions += 1;
            if (i == str.length() - 1 || str.charAt(i) != str.charAt(i + 1)) {
                resultBuilder.append(String.format("%c%d", str.charAt(i), charRepetitions));
                charRepetitions = 0;
            }
        }
        String result = resultBuilder.toString();
        return str.length() <= result.length() ? str : result;
    }
}
