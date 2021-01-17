package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BoardTestSuite {

    @Test
    void testTaskAdd() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        board.addTask("Task to be done", board.getToDoList());
        board.addTask("Task in progress", board.getInProgressList());
        board.addTask("Task done", board.getDoneList());

        assertEquals("Task to be done", board.getToDoList().getTask(0));
        assertEquals("Task in progress", board.getInProgressList().getTask(0));
        assertEquals("Task done", board.getDoneList().getTask(0));
    }
}
