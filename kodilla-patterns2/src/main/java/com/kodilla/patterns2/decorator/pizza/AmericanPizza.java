package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class AmericanPizza extends PizzaOrder {
    public AmericanPizza() {
        setDescription("American Pizza");
    }

    @Override
    BigDecimal getCost() {
        return new BigDecimal("30.00");
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }
}
