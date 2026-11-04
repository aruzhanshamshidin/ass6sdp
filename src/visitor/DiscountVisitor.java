package visitor;

import model.Clothing;
import model.Electronics;
import model.Food;

/**
 * Calculates seasonal discount amounts:
 * Clothing: 20%, Electronics: 10%, Food: 0%
 */
public class DiscountVisitor implements OrderVisitor {
    private double totalDiscount = 0.0;

    public double getTotalDiscount() {
        return totalDiscount;
    }

    @Override
    public void visit(Electronics electronics) {
        totalDiscount += electronics.getPrice() * 0.10;
    }

    @Override
    public void visit(Clothing clothing) {
        totalDiscount += clothing.getPrice() * 0.20;
    }

    @Override
    public void visit(Food food) {
        // No discount on food items (0%)
    }
}
