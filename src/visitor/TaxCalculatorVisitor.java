package visitor;

import model.Clothing;
import model.Electronics;
import model.Food;

/**
 * Calculates sales tax based on item category:
 * Electronics: 15%, Clothing: 5%, Food: 0%
 */
public class TaxCalculatorVisitor implements OrderVisitor {
    private double totalTax = 0.0;

    public double getTotalTax() {
        return totalTax;
    }

    @Override
    public void visit(Electronics electronics) {
        totalTax += electronics.getPrice() * 0.15;
    }

    @Override
    public void visit(Clothing clothing) {
        totalTax += clothing.getPrice() * 0.05;
    }

    @Override
    public void visit(Food food) {
        // Food items are tax-exempt (0%)
    }
}
