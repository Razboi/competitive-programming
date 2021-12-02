public class SimpleEncryption1 {

    // https://www.codewars.com/kata/simple-encryption-number-1-alternating-split/train/java

    public static void main(String[] args) {
        String encryptedMsg = encrypt("s eT ashi tist!", 2);
        System.out.println(encryptedMsg);
        System.out.println(decrypt(encryptedMsg, 2));
    }

    public static String encrypt(String text, int n) {
        if (!isInputValid(text, n)) {
            return text;
        }
        StringBuilder secondCharsBuffer = new StringBuilder();
        StringBuilder otherCharsBuffer = new StringBuilder();
        for (int j = 0; j < text.length(); j++) {
            if ((j + 1) % 2 == 0) {
                secondCharsBuffer.append(text.charAt(j));
            } else {
                otherCharsBuffer.append(text.charAt(j));
            }
        }
        secondCharsBuffer.append(otherCharsBuffer);
        return n <= 1 ? secondCharsBuffer.toString() : encrypt(secondCharsBuffer.toString(), --n);
    }

    public static String decrypt(String encryptedText, int n) {
        if (!isInputValid(encryptedText, n)) {
            return encryptedText;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0, j = 0, k = (encryptedText.length() / 2); i < encryptedText.length(); i++) {
            if ((i + 1) % 2 == 0) {
                result.append(encryptedText.charAt(j));
                j++;
            } else {
                result.append(encryptedText.charAt(k));
                k++;
            }
        }
        return n <= 1 ? result.toString() : decrypt(result.toString(), --n);
    }

    private static boolean isInputValid(String input, int n) {
        return !(input == null || input.isEmpty() || n <= 0);
    }
}
