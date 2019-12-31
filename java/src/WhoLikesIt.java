public class WhoLikesIt {
    //https://www.codewars.com/kata/who-likes-it/train/java

    public static void main(String[] args) {
        System.out.println(whoLikesIt("Peter", "Alex", "Mark", "Maria"));
    }

    public static String whoLikesIt(String... names) {
        switch (names.length) {
            case 1:
                return String.format("%s likes this", names[0]);
            case 2:
                return String.format("%s and %s like this", names[0], names[1]);
            case 3:
                return String.format("%s, %s and %s like this", names[0], names[1], names[2]);
            default:
                return String.format("%s, %s and %d others like this", names[0], names[1], names.length - 2);
        }
    }
}
