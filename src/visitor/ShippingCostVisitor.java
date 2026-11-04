package visitor;

import model.Clothing;
import model.Electronics;
import model.Food;

/**
 * Calculates shipping costs based on item weight and category:
 * Electronics: $5/kg (fragile), Clothing: $2/kg, Food: $3/kg (perishable)
 */
public class ShippingCostVisitor implements OrderVisitor {
    private double totalShippingCost = 0.0;

    public double getTotalShippingCost() {
        return totalShippingCost;
    }

    @Override
    public void visit(Electronics electronics) {
        totalShippingCost += electronics.getWeightKg() * 5.0;
    }

    @Override
    public void visit(Clothing clothing) {
        totalShippingCost += clothing.getWeightKg() * 2.0;
    }

    @Override
    public void visit(Food food) {
        totalShippingCost += food.getWeightKg() * 3.0;
    }
}