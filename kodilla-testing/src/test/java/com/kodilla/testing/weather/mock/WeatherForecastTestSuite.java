package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WeatherForecastTestSuite {

    private WeatherForecast weatherForecast;
    private static int testCounter;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @Mock
    private Temperatures temperaturesMock;

    @BeforeEach
    public void mockSetup() {
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);

        weatherForecast = new WeatherForecast(temperaturesMock);

        System.out.println("Running test #" + testCounter++);
    }

    @Test
    public void testCalculateForecastWithMock() {
        int quantityOfSensors = weatherForecast.calculateForecast().size();
        assertEquals(5, quantityOfSensors);
    }

    @Test
    public void testAverageTemperature(){
        assertEquals(25.56, weatherForecast.averageTemperature(),0.01);
    }

    @Test
    public void testMedianTemperature(){
        assertEquals(25.5, weatherForecast.medianTemperature());
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }
}
