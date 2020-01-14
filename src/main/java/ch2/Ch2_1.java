package ch2;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Ch2_1 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
        LocalDate date = LocalDate.of(year, month, 1);
        int indent = date.getDayOfWeek().getValue() % 7;
        for (int i = 0; i < indent; i++) {
            System.out.print("    ");
        }
        while (date.getMonthValue() == month) {
            System.out.printf("%4d", date.getDayOfMonth());
            if (date.getDayOfWeek().getValue() == 6) {
                System.out.println();
            }
            date = date.plusDays(1);
        }
    }
}
