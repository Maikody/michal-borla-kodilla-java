package com.kodilla.testing.weather.stub;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }

        return resultMap;
    }

    public double averageTemperature(){
        double sum = 0;
        int counter = 0;

        for(double temperature : temperatures.getTemperatures().values()){
            sum += temperature;
            counter++;
        }

        return sum/counter;
    }

    public double medianTemperature(){
        double[] tempArray = new double[temperatures.getTemperatures().size()];
        int index = 0;
        for(double temperature : temperatures.getTemperatures().values()){
            tempArray[index++] = temperature;
        }

        Arrays.sort(tempArray);

        double median;
        if(tempArray.length % 2 != 0)
            median = tempArray[tempArray.length/2];
        else
            median = (tempArray[tempArray.length/2] + tempArray[(tempArray.length/2) - 1])/2;

        return median;
    }
}