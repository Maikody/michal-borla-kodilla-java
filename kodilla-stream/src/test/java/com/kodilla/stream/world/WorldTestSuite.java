package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity(){
        World earth = new World();

        Continent europe = new Continent("Europe");
        europe.addCountry(new Country("Poland",new BigDecimal("10000000000000000")));
        europe.addCountry(new Country("Spain",new BigDecimal("10000000000000000")));
        europe.addCountry(new Country("France",new BigDecimal("10000000000000000")));
        europe.addCountry(new Country("Germany",new BigDecimal("10000000000000000")));
        earth.addContinent(europe);

        Continent africa = new Continent("Africa");
        africa.addCountry(new Country("Egypt",new BigDecimal("10000000000000000")));
        africa.addCountry(new Country("Morocco",new BigDecimal("10000000000000000")));
        africa.addCountry(new Country("Kongo",new BigDecimal("10000000000000000")));
        africa.addCountry(new Country("Senegal",new BigDecimal("10000000000000000")));
        earth.addContinent(africa);

        Continent asia = new Continent("Asia");
        asia.addCountry(new Country("China",new BigDecimal("10000000000000000")));
        asia.addCountry(new Country("Japan",new BigDecimal("10000000000000000")));
        asia.addCountry(new Country("India",new BigDecimal("10000000000000000")));
        asia.addCountry(new Country("Afghanistan",new BigDecimal("10000000000000000")));
        earth.addContinent(asia);

        BigDecimal expectedSum = new BigDecimal("120000000000000000");
        assertEquals(expectedSum, earth.getPeopleQuantity());
    }
}
