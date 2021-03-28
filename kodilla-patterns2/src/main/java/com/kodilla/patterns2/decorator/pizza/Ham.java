package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class Ham extends AbstractPizzaDecorator {

    public Ham(PizzaOrder pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Ham";
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal("2.50"));
    }
}