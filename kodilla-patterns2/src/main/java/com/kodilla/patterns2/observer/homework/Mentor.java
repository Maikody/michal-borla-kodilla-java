package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class Mentor implements Observer {

    private final String name;
    private List<Student> students;
    private int tasksWaitingForChecking;

    public Mentor(String username) {
        this.name = username;
        this.students = new ArrayList<>();
    }

    @Override
    public void update(StudentHomeworks homeworks) {
        System.out.println(name + ", you have a new homework from " + homeworks.getStudent().getName() + " to check: " + homeworks.getHomeworksReadyForChecking().getLast().getDescription() + "\n" +
                " Current homework waiting for checking: " + homeworks.getHomeworksReadyForChecking().getFirst().getDescription() + "\n" +
                " Total tasks to check: " + ++tasksWaitingForChecking);
    }

    public String getName() {
        return name;
    }

    public int getTasksWaitingForChecking() {
        return tasksWaitingForChecking;
    }
}
