package ch7;

import java.util.*;

public class Ch7_12 {
    public static String shuffleSentence(String sentence) {
        if(Character.isUpperCase(sentence.charAt(0))) {
            sentence = sentence.substring(0, 1).toLowerCase() + sentence.substring(1);
        }
        Character last = sentence.charAt(sentence.length() - 1);
        if (!Character.isAlphabetic(last)) {
            sentence = sentence.substring(0, sentence.length() - 1);
        }

        List<String> words = Arrays.asList(sentence.split("\\s+"));
        Collections.shuffle(words);
        String res = String.join(" ", words);
        res = res.substring(0, 1).toUpperCase() + res.substring(1);
        if (!Character.isAlphabetic(last)) {
            res = res + last;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("Input sentence for shuffle:");
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String res = shuffleSentence(line);
        System.out.println(res);
    }
}
