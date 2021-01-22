package com.kodilla.patterns.factory.tasks;

public class PaintingTask implements Task {
    private String taskName;
    private String whatToPaint;
    private String color;
    private boolean isExecuted;

    public PaintingTask(String taskName, String whatToPaint, String color) {
        this.taskName = taskName;
        this.whatToPaint = whatToPaint;
        this.color = color;
        isExecuted = false;
    }

    @Override
    public void executeTask() {
        if (isExecuted) {
            System.out.println("Task already executed, choose different one!");
        } else {
            System.out.println(taskName + " under execution...");
            isExecuted = true;
        }
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return isExecuted;
    }
}
