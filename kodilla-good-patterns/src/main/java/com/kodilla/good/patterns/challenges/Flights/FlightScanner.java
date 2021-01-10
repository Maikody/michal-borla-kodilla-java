package com.kodilla.good.patterns.challenges.Flights;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class FlightScanner {
    private final FlightsDatabase flightsDatabase;

    public FlightScanner(FlightsDatabase flightsDatabase) {
        this.flightsDatabase = flightsDatabase;
    }

    public ArrayList<Flight> checkIfFlightExistsFromCity(String departure) {
        return flightsDatabase.getFlights().stream()
                .filter(flight -> departure.equals(flight.getDeparture()))
                .distinct()
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Flight> checkIfFlightExistsToCity(String arrival) {
        return flightsDatabase.getFlights().stream()
                .filter(flight -> arrival.equals(flight.getArrival()))
                .distinct()
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public Set<Journey> getConnectingFlights(String start, String end) {
        ArrayList<Flight> departures = checkIfFlightExistsFromCity(start);
        ArrayList<Flight> arrivals = checkIfFlightExistsToCity(end);
        Set<Journey> connection = new HashSet<>();

        for(Flight flightFrom : departures) {
            for (Flight flightTo : arrivals) {
                if (flightFrom.getArrival().equals(flightTo.getDeparture())) {
                    connection.add(new Journey(flightFrom, flightTo));
                }
            }
        }

        return connection;
    }

    public void flightInfo(ArrayList<Flight> results) {
        if(results.isEmpty()) {
            System.out.println("\nFlights not found");
            return;
        }
        System.out.println("\nFound flights:");
        results.forEach(System.out::println);
    }

    public void connectingFlightInfo(Set<Journey> results) {
        if(results.isEmpty()) {
            System.out.println("\nFlights not found");
            return;
        }
        System.out.println("\nFound connecting flights:");
        results.forEach(result -> {
                    System.out.println("\tFlight from airport: " + result.getStart().getDeparture() +
                    "\n\tChange at airport: " + result.getStart().getArrival() +
                    "\n\tDestination airport : " + result.getEnd().getArrival() + "\n");
        });
    }

    public void displayFlightsFromCity(String city) {
        ArrayList<Flight> fromCity = checkIfFlightExistsFromCity(city);
        flightInfo(fromCity);
    }

    public void displayFlightsToCity(String city) {
        ArrayList<Flight> toCity = checkIfFlightExistsToCity(city);
        flightInfo(toCity);
    }

    public void displayConnectingFlights(String start, String end) {
        Set<Journey> connectingFlights = getConnectingFlights(start, end);
        connectingFlightInfo(connectingFlights);
    }
}
