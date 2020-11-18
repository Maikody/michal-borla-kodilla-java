package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity(){
        World earth = new World();

        Continent europe = new Continent("Europe");
        europe.getCountries().add(new Country("Poland",new BigDecimal("10000000000000000")));
        europe.getCountries().add(new Country("Spain",new BigDecimal("10000000000000000")));
        europe.getCountries().add(new Country("France",new BigDecimal("10000000000000000")));
        europe.getCountries().add(new Country("Germany",new BigDecimal("10000000000000000")));
        earth.getContinents().add(europe);

        Continent africa = new Continent("Africa");
        europe.getCountries().add(new Country("Egypt",new BigDecimal("10000000000000000")));
        europe.getCountries().add(new Country("Morocco",new BigDecimal("10000000000000000")));
        europe.getCountries().add(new Country("Kongo",new BigDecimal("10000000000000000")));
        europe.getCountries().add(new Country("Senegal",new BigDecimal("10000000000000000")));
        earth.getContinents().add(africa);

        Continent asia = new Continent("Asia");
        europe.getCountries().add(new Country("China",new BigDecimal("10000000000000000")));
        europe.getCountries().add(new Country("Japan",new BigDecimal("10000000000000000")));
        europe.getCountries().add(new Country("India",new BigDecimal("10000000000000000")));
        europe.getCountries().add(new Country("Afghanistan",new BigDecimal("10000000000000000")));
        earth.getContinents().add(asia);

        BigDecimal expectedSum = new BigDecimal("120000000000000000");
        assertEquals(expectedSum, earth.getPeopleQuantity());
    }
}
