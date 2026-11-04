package visitor;

import model.Clothing;
import model.Electronics;
import model.Food;

/**
 * Visitor interface.
 * Declares visit methods for each concrete element in the shopping cart.
 */
public interface OrderVisitor {
    void visit(Electronics electronics);
    void visit(Clothing clothing);
    void visit(Food food);
}
