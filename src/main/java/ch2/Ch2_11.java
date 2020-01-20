package ch2;

import java.time.LocalDate;
import static java.time.LocalDate.now;
import static java.lang.System.out;

public class Ch2_11 {
    public static class Cal {
        public static void print() {
            LocalDate today = now();
            int year = today.getYear();
            int month = today.getMonthValue();
            LocalDate date = LocalDate.of(year, month, 1);
            out.println(" Sun Mon Tue Wed Thu Fri Sat");
            int indent = date.getDayOfWeek().getValue() % 7;
            for (int i = 0; i < indent; i++) {
                out.print("    ");
            }
            while (date.getMonthValue() == month) {
                out.printf("%4d", date.getDayOfMonth());
                if (date.getDayOfWeek().getValue() % 7 == 6) {
                    out.println();
                }
                date = date.plusDays(1);
            }
        }
    }

    public static void main(String[] args) {
        Cal.print();
    }
}
