package model;

import visitor.OrderVisitor;

public class Food implements Item {
    private final String name;
    private final double price;
    private final double weightKg;

    public Food(String name, double price, double weightKg) {
        this.name = name;
        this.price = price;
        this.weightKg = weightKg;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getWeightKg() {
        return weightKg;
    }

    @Override
    public void accept(OrderVisitor visitor) {
        // Double Dispatch: passing concrete type (this == Food)
        visitor.visit(this);
    }
}
