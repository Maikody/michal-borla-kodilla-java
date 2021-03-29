package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentHomeworksTestSuite {

    @Test
    public void testUpdate() {
        Mentor mentorOne = new Mentor("Mateusz Kowalski");
        Mentor mentorTwo = new Mentor("Robert Nowak");
        StudentHomeworks adamMareckiHomeworks = new StudentHomeworks(mentorOne, new Student("Adam Marecki"));
        StudentHomeworks kubaRejentHomeworks = new StudentHomeworks(mentorTwo, new Student("Kuba Rejent"));
        StudentHomeworks michalFigurskiHomeworks = new StudentHomeworks(mentorOne, new Student("Michal Figurski"));
        StudentHomeworks robertJakubowskiHomeworks = new StudentHomeworks(mentorOne, new Student("Robert Jakubowski"));
        Homework homeworkOne = new Homework("Module 7.2 Task");
        Homework homeworkTwo = new Homework("Module 4.5 Task");
        Homework homeworkThree = new Homework("Module 17.4 Task");
        Homework homeworkFour = new Homework("Module 3.5 Task");
        Homework homeworkFive = new Homework("Module 22.1 Task");
        Homework homeworkSix = new Homework("Module 28.6 Task");

        adamMareckiHomeworks.setHomeworkReadyForChecking(homeworkOne);
        adamMareckiHomeworks.setHomeworkReadyForChecking(homeworkFive);
        kubaRejentHomeworks.setHomeworkReadyForChecking(homeworkSix);
        kubaRejentHomeworks.setHomeworkReadyForChecking(homeworkFour);
        kubaRejentHomeworks.setHomeworkReadyForChecking(homeworkFive);
        kubaRejentHomeworks.setHomeworkReadyForChecking(homeworkOne);
        kubaRejentHomeworks.setHomeworkReadyForChecking(homeworkThree);
        michalFigurskiHomeworks.setHomeworkReadyForChecking(homeworkThree);
        michalFigurskiHomeworks.setHomeworkReadyForChecking(homeworkFour);
        michalFigurskiHomeworks.setHomeworkReadyForChecking(homeworkOne);
        michalFigurskiHomeworks.setHomeworkReadyForChecking(homeworkOne);
        robertJakubowskiHomeworks.setHomeworkReadyForChecking(homeworkTwo);
        robertJakubowskiHomeworks.setHomeworkReadyForChecking(homeworkFour);
        robertJakubowskiHomeworks.setHomeworkReadyForChecking(homeworkTwo);
        robertJakubowskiHomeworks.setHomeworkReadyForChecking(homeworkOne);
        robertJakubowskiHomeworks.setHomeworkReadyForChecking(homeworkSix);


        assertEquals(11, mentorOne.getTasksWaitingForChecking());
        assertEquals(5, mentorTwo.getTasksWaitingForChecking());
    }

}