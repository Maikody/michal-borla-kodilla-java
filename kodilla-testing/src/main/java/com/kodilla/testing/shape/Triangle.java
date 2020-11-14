package com.kodilla.testing.shape;

public class Triangle implements Shape {

    private double wallLength;
    private double height;

    public Triangle(double wallLength, double height) {
        this.wallLength = wallLength;
        this.height = height;
    }

    @Override
    public double getField() {
        return 0.5*wallLength*height;
    }

}
