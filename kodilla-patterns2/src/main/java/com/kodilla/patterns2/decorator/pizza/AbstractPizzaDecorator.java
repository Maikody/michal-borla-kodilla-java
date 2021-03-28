package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public abstract class AbstractPizzaDecorator extends PizzaOrder {
    private PizzaOrder pizza;

    public AbstractPizzaDecorator(PizzaOrder pizza) {
        this.pizza = pizza;
    }

    @Override
    BigDecimal getCost() {
        return pizza.getCost();
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }
}
