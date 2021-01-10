package com.kodilla.good.patterns.challenges.Flights;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlightsDatabase {
    private static final FlightsDatabase instance = new FlightsDatabase();

    private static final List<Flight> flightsDatabase = new ArrayList<>();

    static {
        flightsDatabase.add(new Flight("Warsaw", "London"));
        flightsDatabase.add(new Flight("Warsaw", "Paris"));
        flightsDatabase.add(new Flight("Paris", "Lisbon"));
        flightsDatabase.add(new Flight("Moscow", "Paris"));
        flightsDatabase.add(new Flight("Madrid", "Berlin"));
        flightsDatabase.add(new Flight("Oslo", "Rome"));
        flightsDatabase.add(new Flight("London", "Lisbon"));
        flightsDatabase.add(new Flight("Paris", "Tokyo"));
        flightsDatabase.add(new Flight("Lisbon", "Berlin"));
        flightsDatabase.add(new Flight("Warsaw", "London"));
    }

    private FlightsDatabase() {
    }

    public static FlightsDatabase getInstance() {
        return instance;
    }

    public List<Flight> getFlights(){
        return Collections.unmodifiableList(flightsDatabase);
    }
}
