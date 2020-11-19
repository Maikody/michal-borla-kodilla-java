package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {
    public static double expectedAverage = 0;

    @Test
    public void testGetAverage(){
        int[] input = arrayGenerator();

        assertEquals(expectedAverage, ArrayOperations.getAverage(input));
    }

    public int[] arrayGenerator(){
        int[] array = new int[20];
        int sum = 0;

        Random random = new Random();
        for(int i = 0; i < 20; i++) {
            array[i] = random.nextInt(10);
            sum += array[i];
        }

        expectedAverage = (double) sum / 20;

        return array;
    }
}
