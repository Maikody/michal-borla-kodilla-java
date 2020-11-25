package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightScanner {

    public boolean findFlight (Flight flight) throws RouteNotFoundException{
        if (flight != null) {
            Map<String, Boolean> citiesMap = new HashMap<>();
            FlightsDatabase flightsDatabase = new FlightsDatabase();

            for (Flight flightRoute : flightsDatabase.getFlights()) {
                citiesMap.put(flightRoute.getDepartureAirport(), false);
                citiesMap.put(flightRoute.getArrivalAirport(), true);
            }

            if (!citiesMap.containsKey(flight.getArrivalAirport()) || !citiesMap.get(flight.getArrivalAirport())) {
                throw new RouteNotFoundException();
            }

            return true;
        }
        return false;
    }

}
