import cart.ShoppingCart;
import model.Clothing;
import model.Electronics;
import model.Food;
import visitor.DiscountVisitor;
import visitor.ShippingCostVisitor;
import visitor.TaxCalculatorVisitor;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem(new Electronics("ASUS Vivobook S14 Laptop", 1000.0, 1.4));
        cart.addItem(new Clothing("Marsala Autumn Jacket", 150.0, 1.2));
        cart.addItem(new Food("Chicken Breast Pack", 20.0, 2.0));

        TaxCalculatorVisitor taxVisitor = new TaxCalculatorVisitor();
        DiscountVisitor discountVisitor = new DiscountVisitor();
        ShippingCostVisitor shippingVisitor = new ShippingCostVisitor();

        cart.accept(taxVisitor);
        cart.accept(discountVisitor);
        cart.accept(shippingVisitor);

        double baseTotal = cart.calculateBaseTotal();
        double tax = taxVisitor.getTotalTax();
        double discount = discountVisitor.getTotalDiscount();
        double shipping = shippingVisitor.getTotalShippingCost();
        double finalTotal = baseTotal - discount + tax + shipping;

        System.out.println("=== E-COMMERCE ORDER COST CALCULATION ===");
        System.out.println("Items in Shopping Cart:");
        System.out.println(" 1. Electronics: ASUS Vivobook S14 ($1000.0, 1.4 kg)");
        System.out.println(" 2. Clothing: Marsala Jacket ($150.0, 1.2 kg)");
        System.out.println(" 3. Food: Grocery Pack ($20.0, 2.0 kg)");
        System.out.println("--------------------------------------------------");
        System.out.printf("Base Subtotal:              $%8.2f%n", baseTotal);
        System.out.printf("Discount Amount:           -$%8.2f%n", discount);
        System.out.printf("Sales Tax:                 +$%8.2f%n", tax);
        System.out.printf("Shipping Cost:             +$%8.2f%n", shipping);
        System.out.println("--------------------------------------------------");
        System.out.printf("GRAND TOTAL TO PAY:         $%8.2f%n", finalTotal);
    }
}