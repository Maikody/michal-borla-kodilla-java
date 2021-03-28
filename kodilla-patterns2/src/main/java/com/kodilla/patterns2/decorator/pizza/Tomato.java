package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class Tomato extends AbstractPizzaDecorator {

    public Tomato(PizzaOrder pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Tomato";
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal("1.00"));
    }
}
