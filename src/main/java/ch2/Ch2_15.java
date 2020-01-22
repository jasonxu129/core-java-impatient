package ch2;

import java.util.ArrayList;

public class Ch2_15 {
    public static class Invoice {
        public static class Item {
            private String description;
            private int quantity;
            private double unitPrice;

            public Item(String desc, int quantity, double unitPrice) {
                this.description = desc;
                this.quantity = quantity;
                this.unitPrice = unitPrice;
            }

            public double price() {
                return quantity * unitPrice;
            }

            public String toString() {
                return String.format("%s, %d, %f, total: %f", description, quantity, unitPrice, price());
            }
        }

        private ArrayList<Item> items = new ArrayList<>();

        public void add(Item item) {
            items.add(item);
        }

        public void print() {
            for (Item item : items) {
                System.out.println(item);
            }
        }
    }

    public static void main(String[] args) {
        Invoice invoice = new Invoice();
        Invoice.Item item1 = new Invoice.Item("jacket", 2, 60);
        Invoice.Item item2 = new Invoice.Item("shoes", 1, 80);
        invoice.add(item1);
        invoice.add(item2);
        invoice.print();
    }
}
