package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public abstract class PizzaOrder {
    abstract BigDecimal getCost();

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
