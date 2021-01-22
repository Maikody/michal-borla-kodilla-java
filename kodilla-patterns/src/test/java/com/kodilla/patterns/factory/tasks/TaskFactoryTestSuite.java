package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {
    private final TaskFactory factory = new TaskFactory();

    @Test
    void testFactoryShopping() {
        Task shoppingTask = factory.defineTask(TaskFactory.SHOPPING);
        shoppingTask.executeTask();
        assertEquals("Weekend shopping", shoppingTask.getTaskName());
        assertTrue(shoppingTask.isTaskExecuted());
    }

    @Test
    void testFactoryPainting() {
        Task paintingTask = factory.defineTask(TaskFactory.PAINTING);
        paintingTask.executeTask();
        assertEquals("Apartment renovation", paintingTask.getTaskName());
        assertTrue(paintingTask.isTaskExecuted());
    }

    @Test
    void testFactoryDriving() {
        Task drivingTask = factory.defineTask(TaskFactory.DRIVING);
        drivingTask.executeTask();
        assertEquals("Road trip", drivingTask.getTaskName());
        assertTrue(drivingTask.isTaskExecuted());
    }
}
