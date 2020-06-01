package ch9;

import java.util.regex.Pattern;

public class Ch9_12 {
    public static void main(String[] args) {
        String date = "2020/5/30";

        String regex = "(\\d{4})/(?<month>\\d{1,2})/(?<day>\\d{1,2})";
        Pattern pattern = Pattern.compile(regex);
        // Reformat date to month/day/year;
        String reformattedDate = pattern.matcher(date).replaceAll("${month}/${day}/$1");
        System.out.println(reformattedDate);
    }
}
