package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {

    @Test
    public void testGetAverage(){
        int[] input = {0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1};

        assertEquals(0.5, ArrayOperations.getAverage(input));
    }

}
