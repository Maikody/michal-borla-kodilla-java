package com.kodilla.good.patterns.challenges.Flights;

public class FlightApp {

    public static void main(String[] args) {
        FlightScanner flightScanner = new FlightScanner(FlightsDatabase.getInstance());

        flightScanner.displayFlightsFromCity("Warsaw");
        flightScanner.displayFlightsToCity("Berlin");
        flightScanner.displayConnectingFlights("Warsaw", "Lisbon");
    }

}
