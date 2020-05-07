package ch8;

public class Ch8_06 {
    public static boolean isOnlyLetters(String s) {
        return s.codePoints().allMatch(Character::isAlphabetic);
    }

    public static void main(String[] args) {
        System.out.println(isOnlyLetters("hello123"));
        System.out.println(isOnlyLetters("world"));
    }
}
