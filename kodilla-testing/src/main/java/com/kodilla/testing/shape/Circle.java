package com.kodilla.testing.shape;

public class Circle implements Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getField() {
        return Math.PI*Math.pow(radius, 2);
    }

}
