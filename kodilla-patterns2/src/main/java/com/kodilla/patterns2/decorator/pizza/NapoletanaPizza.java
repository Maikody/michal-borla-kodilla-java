package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class NapoletanaPizza extends PizzaOrder {
    public NapoletanaPizza() {
        setDescription("Pizza Napoletana");
    }

    @Override
    BigDecimal getCost() {
        return new BigDecimal("40.00");
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }
}
