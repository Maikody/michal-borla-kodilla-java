package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";

    public final Task defineTask(String taskName) {
        switch(taskName) {
            case SHOPPING:
                return new ShoppingTask("Weekend shopping","Shoes", 1.0);
            case PAINTING:
                return new PaintingTask("Apartment renovation", "Living room walls", "White");
            case DRIVING:
                return new DrivingTask("Road trip", "Italy", "Car");
            default:
                return null;
        }
    }
}
