package cart;

import model.Item;
import visitor.OrderVisitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Object Structure (Shopping Cart).
 * Holds a collection of items and traverses them when accepting a visitor.
 */
public class ShoppingCart {
    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }

    public double calculateBaseTotal() {
        return items.stream()
                .mapToDouble(item -> {
                    if (item instanceof model.Electronics e) return e.getPrice();
                    if (item instanceof model.Clothing c) return c.getPrice();
                    if (item instanceof model.Food f) return f.getPrice();
                    return 0.0;
                })
                .sum();
    }

    public void accept(OrderVisitor visitor) {
        for (Item item : items) {
            item.accept(visitor);
        }
    }
}
