package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class Chicken extends AbstractPizzaDecorator {

    public Chicken(PizzaOrder pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Chicken";
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal("4"));
    }
}