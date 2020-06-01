package ch9;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ch9_10 {

    public static ArrayList<Integer> extractDecimalIntegers(String str) {
        ArrayList<Integer> res = new ArrayList<>();
        Pattern pattern = Pattern.compile("[+-]?\\d+");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            Integer i = Integer.parseInt(matcher.group());
            res.add(i);
        }
        return res;
    }

    public static ArrayList<Integer> extractIntegersBySplitting(String str) {
        ArrayList<Integer> res = new ArrayList<>();
        // Or use str.trim().split()
        Pattern pattern = Pattern.compile("[+-]?\\s+");
        String[] tokens = pattern.split(str.trim());
        for (String t : tokens) {
            Integer i = Integer.parseInt(t);
            res.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        String str = " 34 2 +124 -48  +333 9876 ";
        ArrayList<Integer> list = extractDecimalIntegers(str);
        System.out.println(list);

        ArrayList<Integer> list2 = extractIntegersBySplitting(str);
        System.out.println(list2);
    }
}
