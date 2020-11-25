package com.kodilla.exception.test;

public class FlightApp {

    public static void main(String[] args) {
        FlightScanner flightScanner = new FlightScanner();
        Flight flight1 = new Flight("London", "Dublin");

        try {
            System.out.println(flightScanner.findFlight(flight1));
        } catch (RouteNotFoundException e) {
            System.out.println("There is no flights to " + flight1.getArrivalAirport());
        }

    }

}
