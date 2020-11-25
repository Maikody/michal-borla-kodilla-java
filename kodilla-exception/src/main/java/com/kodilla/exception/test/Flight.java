package com.kodilla.exception.test;

import java.util.Objects;

public final class Flight {
    private final String departureAirport;
    private final String arrivalAirport;

    public Flight(String departureAirport, String arrivalAirport) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(departureAirport, flight.departureAirport) &&
                Objects.equals(arrivalAirport, flight.arrivalAirport);
    }

}
