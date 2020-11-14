package com.kodilla.testing.shape;

public class Square implements Shape {

    private double wallLength;

    public Square(double wallLength) {
        this.wallLength = wallLength;
    }

    @Override
    public double getField() {
        return Math.pow(wallLength, 2);
    }

}
