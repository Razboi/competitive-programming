import java.lang.Math;

/* There are three types of edits that can be performed on strings: insert a character, remove a character or replace a character.
 * Given two strings, write a function to check if they are one edit (or zero edits) away
 * */
class IsOneAway {
    public static void main(String args[]) {
        System.out.println(isOneAway("pale", "ple"));
        System.out.println(isOneAway("pales", "pale"));
        System.out.println(isOneAway("pale", "bale"));
        System.out.println(isOneAway("pale", "bake"));
    }

    private static boolean isOneAwayEqualLength(String str1, String str2) {
        boolean hasDifferenceBeenFound = false;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                if (hasDifferenceBeenFound) {
                    return false;
                }
                hasDifferenceBeenFound= true;
            }
        }
        return true;
    }

    private static boolean isOneAwayDifferentLength(String longest, String shortest) {
        boolean hasDifferenceBeenFound = false;
        int shortestIndex = 0;
        int longestIndex = 0;

        while (shortestIndex < shortest.length()) {
            if (longest.charAt(longestIndex) != shortest.charAt(shortestIndex)) {
                if (hasDifferenceBeenFound) {
                    return false;
                }
                hasDifferenceBeenFound = true;
            } else {
                shortestIndex++;
            }
            longestIndex++;
        }
        return true;
    }

    // time complexity: O(n), space complexity: O(1)
    private static boolean isOneAway(String str1, String str2) {
        int lengthDifference = Math.abs(str1.length() - str2.length());
        boolean hasDifferenceBeenFound = false;

        if (lengthDifference == 0) {
            return isOneAwayEqualLength(str1, str2);
        } else if (lengthDifference == 1) {
            return str1.length() > str2.length() ? isOneAwayDifferentLength(str1, str2) : isOneAwayDifferentLength(str2, str1);
        } else {
            return false;
        }
    }
}
