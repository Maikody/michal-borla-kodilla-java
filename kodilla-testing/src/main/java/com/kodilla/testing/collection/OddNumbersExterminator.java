package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator {

    public static List<Integer> exterminate(List<Integer> numbers){
        List<Integer> evenNumbers = new ArrayList<>();

        for (int num:numbers){
            if(num % 2 == 0 && num != 0){
                evenNumbers.add(num);
            }
        }

        if(evenNumbers.isEmpty())
            return null;

        return evenNumbers;
    }

}
