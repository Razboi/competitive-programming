import java.util.Hashtable;
import java.util.Arrays;

/* Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
 *
 * */

class IsStringUnique {
    // assuming ASCII
    static int CHARSET_LENGTH = 128;

    public static void main(String[] args) {
        System.out.println(isStringUnique("test"));
        System.out.println(isStringUniqueBitArray("test"));
        System.out.println(isStringUniqueWithoutDataStructures("test"));
        System.out.println(isStringUnique("tesp"));
        System.out.println(isStringUniqueBitArray("tesp"));
        System.out.println(isStringUniqueWithoutDataStructures("tesp"));
    }


    // time complexity: O(c), space complexity: O(c)
    // being c the charset length
    public static boolean isStringUnique(String string) {
        if (string.length() > CHARSET_LENGTH) {
            return false;
        }
        Hashtable<Character, Boolean> charToExistenceTable = new Hashtable<Character, Boolean>();
        for (char stringChar : string.toCharArray()) {
            if (charToExistenceTable.containsKey(stringChar)) {
                return false;
            }
            charToExistenceTable.put(stringChar, true);
        }
        return true;
    }

    // time complexity: O(c), space complexity: O(c)
    // being c the charset length
    public static boolean isStringUniqueBitArray(String string) {
        if (string.length() > CHARSET_LENGTH) {
            return false;
        }
        Boolean[] bitArray = new Boolean[CHARSET_LENGTH];
        for (char stringChar : string.toCharArray()) {
            int charCode = (int) stringChar;
            if (bitArray[charCode] != null) {
                return false;
            }
            bitArray[charCode] = true;
        }
        return true;
    }

    // time complexity: O(c logc), space complexity O(c)
    // being c the charset length
    public static boolean isStringUniqueWithoutDataStructures(String string) {
        if (string.length() > CHARSET_LENGTH) {
            return false;
        }
        char[] charArray = string.toCharArray();
        Arrays.sort(charArray);
        for (int i = 0; i < charArray.length - 1; i++) {
            if (charArray[i] == charArray[i + 1]) {
                return false;
            }
        }
        return true;
    }
}




