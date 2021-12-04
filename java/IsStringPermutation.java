import java.util.Hashtable;
import java.util.Arrays;

// Given two strings, write a method to decide if one is a permutation of the other.
class IsStringPermutation {
    public static void main(String[] args) {
        System.out.println(isStringPermutation("test", "ttse"));
        System.out.println(isStringPermutation("test", "ttse "));
        System.out.println(isStringPermutation("test", "ttsee"));

        System.out.println(isStringPermutationUsingArray("test", "ttse"));
        System.out.println(isStringPermutationUsingArray("test", "ttse "));
        System.out.println(isStringPermutationUsingArray("test", "ttsee"));

        System.out.println(isStringPermutationUsingSort("test", "ttse"));
        System.out.println(isStringPermutationUsingSort("test", "ttse "));
        System.out.println(isStringPermutationUsingSort("test", "ttsee"));
    }

    private static Integer sumStringCharcodes(String string) {
        Integer sum = 0;
        for (Character stringChar : string.toCharArray()) {
            sum += (int) stringChar;
        }
        return sum;
    }

    // time complexity: O(n), space complexity: O(1)
    public static Boolean isStringPermutation(String original, String target) {
        if (original.length() != target.length()) {
            return false;
        }
        int originalSum = sumStringCharcodes(original);
        int targetSum = sumStringCharcodes(target);
        return originalSum == targetSum;
    }

    // time complexity: O(n), space complexity: O(c) being c the charset length
    public static Boolean isStringPermutationUsingArray(String original, String target) {
        if (original.length() != target.length()) {
            return false;
        }
        // assuming ASCII
        int[] charactersCount = new int[128];
        for (Character stringChar : original.toCharArray()) {
            charactersCount[(int)stringChar]++;
        }
        for (Character stringChar : target.toCharArray()) {
            Integer charCode = (int) stringChar;
            charactersCount[charCode]--;
            if (charactersCount[charCode] < 0) {
                return false;
            }
        }
        return true;
    }

    // time complexity: O(n logn), space complexity: O(1)
    public static Boolean isStringPermutationUsingSort(String original, String target) {
        if (original.length() != target.length()) {
            return false;
        }
        char[] originalChars = original.toCharArray();
        char[] targetChars = target.toCharArray();
        Arrays.sort(originalChars);
        Arrays.sort(targetChars);
        return Arrays.equals(originalChars, targetChars);
    }
}
