package com.kodilla.exception.test;

import java.util.ArrayList;
import java.util.List;

public class FlightsDatabase {
    private List<Flight> flightsDatabase;

    public FlightsDatabase() {
        this.flightsDatabase = new ArrayList<>();
        this.flightsDatabase.add(new Flight("Warsaw", "Paris"));
        this.flightsDatabase.add(new Flight("Moscow", "London"));
        this.flightsDatabase.add(new Flight("Madrid", "Berlin"));
        this.flightsDatabase.add(new Flight("Oslo", "Rome"));
    }

    public boolean addFlight(Flight flight){
        if (flight != null) {
            flightsDatabase.add(flight);
            return true;
        }
        return false;
    }

    public boolean removeFlight(Flight flight){
        if (flight != null) {
            return flightsDatabase.remove(flight);
        }
        return false;
    }

    public int numberOfFlights(){
        return flightsDatabase.size();
    }

    public List<Flight> getFlights(){
        return flightsDatabase;
    }

}
