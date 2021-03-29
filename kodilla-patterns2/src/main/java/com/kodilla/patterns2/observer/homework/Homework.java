package com.kodilla.patterns2.observer.homework;

public class Homework {

    private final String description;
    private HomeworkStatus homeworkStatus;

    enum HomeworkStatus {
            INWORK, READY
    }

    public Homework(String description) {
        this.description = description;
        homeworkStatus = HomeworkStatus.INWORK;
    }

    public String getDescription() {
        return description;
    }

    public HomeworkStatus getHomeworkStatus() {
        return homeworkStatus;
    }

    public void setHomeworkStatus(HomeworkStatus homeworkStatus) {
        this.homeworkStatus = homeworkStatus;
    }
}
