package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionTestSuite {
    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @DisplayName("When result list is empty, then exterminate() should return null")
    @Test
    public void testOddNumbersExterminatorEmptyList(){
        System.out.println("Running OddNumbersExterminatorEmptyListTest... ");
        Assertions.assertNull(OddNumbersExterminator.exterminate(new ArrayList<>()));
    }

    @DisplayName("When result list contains numbers, then exterminate() should return true if all numbers are even")
    @Test
    public void testOddNumbersExterminatorNormalList(){
        System.out.println("Running OddNumbersExterminatorNormalListTest... ");
        List<Integer> expectedList = Arrays.asList(2,6,8);
        List<Integer> methodResultList = OddNumbersExterminator.exterminate(Arrays.asList(2,5,6,7,8));
        Assertions.assertArrayEquals(expectedList.toArray(), methodResultList.toArray());
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }
}
