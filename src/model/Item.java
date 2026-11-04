package model;

import visitor.OrderVisitor;

/**
 * Element interface (Visitable).
 * Declares the contract for accepting a visitor.
 */
public interface Item {
    void accept(OrderVisitor visitor);
}