package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class Spinach extends AbstractPizzaDecorator {

    public Spinach(PizzaOrder pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Spinach";
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal("2.00"));
    }
}