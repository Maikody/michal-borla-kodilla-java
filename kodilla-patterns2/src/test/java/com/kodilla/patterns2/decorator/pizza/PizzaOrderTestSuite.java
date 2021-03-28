package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaOrderTestSuite {

    @Test
    public void testAmericanPizzaCost() {
        PizzaOrder order = new Tomato(
                                new Cheese(
                                        new Chicken(
                                                new Ham(
                                                        new AmericanPizza()))));

        BigDecimal cost = order.getCost();

        assertEquals(new BigDecimal("39.00"), cost);
    }

    @Test
    public void testAmericanPizzaDescription() {
        PizzaOrder order = new Tomato(
                                new Cheese(
                                        new Chicken(
                                                new Ham(
                                                        new AmericanPizza()))));

        String description = order.getDescription();

        assertEquals("American Pizza, Ham, Chicken, Cheese, Tomato", description);
    }

    @Test
    public void testNapoletanaPizzaCost() {
        PizzaOrder order = new Tomato(
                                new Cheese(
                                        new Spinach(
                                                new NapoletanaPizza())));

        BigDecimal cost = order.getCost();

        assertEquals(new BigDecimal("44.50"), cost);
    }

    @Test
    public void testNapoletanaPizzaDescription() {
        PizzaOrder order = new Tomato(
                                new Cheese(
                                        new Spinach(
                                                new NapoletanaPizza())));

        String description = order.getDescription();

        assertEquals("Pizza Napoletana, Spinach, Cheese, Tomato", description);
    }
}
