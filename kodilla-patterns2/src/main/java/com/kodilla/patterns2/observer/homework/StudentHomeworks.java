package com.kodilla.patterns2.observer.homework;

import java.util.ArrayDeque;
import java.util.Deque;

import static com.kodilla.patterns2.observer.homework.Homework.*;

public class StudentHomeworks implements Observable {

    private final Student student;
    private final Observer mentor;
    private final Deque<Homework> homeworksReadyForChecking;

    public StudentHomeworks(Observer mentor, Student student) {
        this.mentor = mentor;
        this.student = student;
        homeworksReadyForChecking = new ArrayDeque<>();
    }

    public void setHomeworkReadyForChecking(Homework homework) {
        homeworksReadyForChecking.add(homework);
        homework.setHomeworkStatus(HomeworkStatus.READY);
        notifyObserver();
    }

    @Override
    public void notifyObserver() {
        mentor.update(this);
    }

    public Deque<Homework> getHomeworksReadyForChecking() {
        return homeworksReadyForChecking;
    }

    public Student getStudent() {
        return student;
    }
}
