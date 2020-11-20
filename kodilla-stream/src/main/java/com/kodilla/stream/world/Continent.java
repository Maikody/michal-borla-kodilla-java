package com.kodilla.stream.world;

import java.util.Objects;
import java.util.Set;
import java.util.HashSet;

public class Continent {
    private final String continentName;
    private Set<Country> countries;

    public Continent(String continentName) {
        this.continentName = continentName;
        this.countries = new HashSet<>();
    }

    public String getContinentName() {
        return continentName;
    }

    public Set<Country> getCountries(){
        return countries;
    }

    public void addCountry(Country country){
        countries.add(country);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Continent continent = (Continent) o;
        return Objects.equals(continentName, continent.continentName);
    }

    @Override
    public int hashCode() {
        return continentName.hashCode();
    }

}
