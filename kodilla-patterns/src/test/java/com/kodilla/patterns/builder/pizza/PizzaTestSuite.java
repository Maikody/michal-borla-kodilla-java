package com.kodilla.patterns.builder.pizza;

import com.kodilla.patterns.builder.Pizza;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PizzaTestSuite {
    @Test
    void testPizzaNew() {
        Pizza pizza = new Pizza.PizzaBuilder()
                .ingredient("Onion")
                .bottom("Thin")
                .sauce("Spicy")
                .ingredient("Ham")
                .ingredient("Mushrooms")
                .build();
        System.out.println(pizza);
        int howManyIngredients = pizza.getIngredients().size();
        assertEquals(3, howManyIngredients);
    }
}
