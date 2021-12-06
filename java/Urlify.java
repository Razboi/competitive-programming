/* Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space
 * at the end to hold the additional characters, and that you are given the "true" length of the string.
 * */
class Urlify {
    public static void main(String args[]) {
        System.out.println(urlify("te st  ".toCharArray(), 5));
        System.out.println(urlify("t e st    ".toCharArray(), 6));
        System.out.println(urlify("test".toCharArray(), 4));
    }

    private static String urlify(char str[], int finalLength) {
        int newIndex = str.length - 1;
        int numSpacesFound = 0;
        for (int oldIndex = finalLength - 1; oldIndex >= 0; oldIndex--) {
            if (str[oldIndex] == ' ') {
                str[newIndex - numSpacesFound * 2] = '0';
                str[newIndex - 1 - numSpacesFound * 2] = '2';
                str[newIndex - 2 - numSpacesFound * 2] = '%';
                numSpacesFound += 1;
            } else {
                str[newIndex - numSpacesFound * 2] = str[oldIndex];
            }
            newIndex -= 1;
        }
        return String.valueOf(str);
    }
}
