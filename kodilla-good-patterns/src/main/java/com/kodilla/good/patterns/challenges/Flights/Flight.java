package com.kodilla.good.patterns.challenges.Flights;

import java.util.Objects;

public final class Flight {
    private final String departure;
    private final String arrival;

    public Flight(String departureAirport, String arrivalAirport) {
        this.departure = departureAirport;
        this.arrival = arrivalAirport;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(departure, flight.departure) &&
                Objects.equals(arrival, flight.arrival);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departure, arrival);
    }

    @Override
    public String toString() {
        return "\tDeparture: " + departure + " - Arrival: " + arrival;
    }
}
