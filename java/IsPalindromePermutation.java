import java.util.Hashtable;

// Given a string, write a function to check if it is a permutation of a palindrome.
class IsPalindromePermutation {
    public static void main(String args[]) {
        System.out.println(isPalindromePermutation(" tenet"));
        System.out.println(isPalindromePermutation("tn eet"));
        System.out.println(isPalindromePermutation("tnE te"));
        System.out.println(isPalindromePermutation("tneeta"));
        System.out.println(isPalindromePermutation("Tact Coa"));

        System.out.println(isPalindromePermutationBitVector(" tenet"));
        System.out.println(isPalindromePermutationBitVector("tn eet"));
        System.out.println(isPalindromePermutationBitVector("tnE te"));
        System.out.println(isPalindromePermutationBitVector("tneeta"));
        System.out.println(isPalindromePermutationBitVector("Tact Coa"));
    }

    // time complexity: O(n), space complexity: O(n)
    private static boolean isPalindromePermutation(String str) {
        Hashtable<Character, Integer> characterToCount = new Hashtable<Character, Integer>();
        for (char c : str.toLowerCase().toCharArray()) {
            if (c == ' ') {
                continue;
            } else if (characterToCount.get(c) != null) {
                characterToCount.put(c, characterToCount.get(c) + 1);
            } else {
                characterToCount.put(c, 1);
            }
        }
        boolean foundOddCountChar = false;
        for (int charCount : characterToCount.values()) {
            if (charCount % 2 != 0) {
                if (foundOddCountChar) {
                    return false;
                }
                foundOddCountChar = true;
            }
        }
        return true;
    }

    // time complexity: O(n), space complexity: O(m) being m the charset length (128 for ASCII or 144.697 for UNICODE)
    private static boolean isPalindromePermutationBitVector(String str) {
        // assuming ASCII
        int charCodeToCountBitVector[] = new int[128];
        for (char c : str.toLowerCase().toCharArray()) {
            int charCode = (int) c;
            if (c == ' ') {
                continue;
            } else {
                charCodeToCountBitVector[charCode] = charCodeToCountBitVector[charCode] + 1;
            }
        }
        boolean foundOddCountChar = false;
        for (int charCount : charCodeToCountBitVector) {
            if (charCount % 2 != 0) {
                if (foundOddCountChar) {
                    return false;
                }
                foundOddCountChar = true;
            }
        }
        return true;
    }
}
