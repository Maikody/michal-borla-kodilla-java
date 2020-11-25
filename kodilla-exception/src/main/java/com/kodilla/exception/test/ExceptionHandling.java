package com.kodilla.exception.test;

public class ExceptionHandling {

    public static void main(String[] args) {
        SecondChallenge challenge = new SecondChallenge();

        try {
            System.out.println(challenge.probablyIWillThrowException(3, 1.5));
        } catch (Exception e) {
            System.out.println("Forbidden data used!");
        } finally {
            System.out.println("End of the program");
        }
    }

}
