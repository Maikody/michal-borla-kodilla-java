package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorTestSuite {
    @Autowired
    public Calculator calculator;

    @Test
    void testCalculations() {
        assertEquals(5.0, calculator.add(2.5, 2.5),0.01);

        assertEquals(0.0, calculator.sub(2.5, 2.5),0.01);

        assertEquals(4.0, calculator.mul(2.0, 2.0),0.01);

        assertEquals(1.0, calculator.div(2.0, 2.0),0.01);
    }

}
