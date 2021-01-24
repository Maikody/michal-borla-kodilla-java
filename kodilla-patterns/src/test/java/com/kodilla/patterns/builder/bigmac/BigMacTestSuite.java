package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigMacTestSuite {

    @Test
    void testBigMacCreation() {
        BigMac bigmac = new BigMac.BigMacBuilder()
                .bun("Sesame")
                .burgers(2)
                .sauce("Barbecue")
                .ingredient("Salad")
                .ingredient("Tomato")
                .build();
        int quantityOfIngredients = bigmac.getIngredients().size();
        assertEquals(2, quantityOfIngredients);
    }

}
