package ch4;

public class Ch4_7 {
    public static enum Color {
        BLACK, RED, GREEN, BLUE, CYAN, MAGENTA, YELLOW, WHITE;

        public static Color getRed() {
            return RED;
        }

        public static Color getBlue() {
            return BLUE;
        }

        public static Color getGreen() {
            return GREEN;
        }
    }

    public static void main(String[] args) {
        Color red = Color.getRed();
        System.out.println("red: " + red);
        Color blue = Color.getBlue();
        System.out.println("blue: " + blue);
    }
}
