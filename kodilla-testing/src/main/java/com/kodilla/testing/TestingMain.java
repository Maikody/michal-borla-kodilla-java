package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args) {
        System.out.println("Test user - pierwszy test jednostkowy:");
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser"))
            System.out.println("test OK");
        else
            System.out.println("Error!");

        System.out.println("Test calculator_add - drugi test jednostkowy:");
        int a = 5;
        int b = 10;
        int sum = a + b;

        if (sum == Calculator.add(a,b))
            System.out.println("test OK");
        else
            System.out.println("Error!");

        System.out.println("Test calculator_subtract - trzeci test jednostkowy:");
        int subtract = a - b;

        if (subtract == Calculator.subtract(a,b))
            System.out.println("test OK");
        else
            System.out.println("Error!");
    }
}
