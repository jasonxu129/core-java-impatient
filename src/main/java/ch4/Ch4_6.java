package ch4;

import java.util.Objects;

public class Ch4_6 {
    public static class Item {
        private String description;
        private double price;

        public Item(String description, double price) {
            this.description = description;
            this.price = price;
        }

        @Override
        public boolean equals(Object otherObject) {
            // A quick test to see if the objects are identical
            if (this == otherObject) return true;
            // Must return false if the parameter is null
            if (otherObject == null) return false;
            // Check that otherObject is an Item
            if (!(otherObject instanceof Item)) return false;
            // Test whether the instance variables have identical values
            Item otherItem = (Item)otherObject;
            return Objects.equals(description, otherItem.description)
                    && price == otherItem.price;
        }

        @Override
        public int hashCode() {
            return Objects.hash(description, price);
        }
    }

    public static class DiscountedItem extends Item {
        private double discount;
        public DiscountedItem(String description, double price, double discount) {
            super(description, price);
            this.discount = discount;
        }

        @Override
        public boolean equals(Object otherObject) {
            if (!super.equals(otherObject)) return false;
            if (otherObject instanceof DiscountedItem) {
                DiscountedItem other = (DiscountedItem) otherObject;
                return discount == other.discount;
            } else if (otherObject instanceof Item) {
                return true;
            } else {
                // Other subclass of Item
                return false;
            }
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), discount);
        }
    }

    public static void main(String[] args) {
        DiscountedItem x = new DiscountedItem("Apple", 2.0, 0.9);
        Item y = new Item("Apple", 2.0);
        DiscountedItem z = new DiscountedItem("Apple", 2.0, 0.8);
        System.out.println("x == y:" + x.equals(y));
        System.out.println("y == z:" + y.equals(z));
        System.out.println("x == z:" + x.equals(z));
    }
}
