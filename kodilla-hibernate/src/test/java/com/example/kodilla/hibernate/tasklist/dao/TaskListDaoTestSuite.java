package com.example.kodilla.hibernate.tasklist.dao;

import com.example.kodilla.hibernate.task.Task;
import com.example.kodilla.hibernate.task.TaskFinancialDetails;
import com.example.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;

    @Test
    void findByListName() {
        TaskList taskList = new TaskList("ToDo","Tasks to be done");
        taskListDao.save(taskList);
        String listNameToFind = taskList.getListName();
        List<TaskList> readTaskLists = taskListDao.findByListName(listNameToFind);

        assertEquals(1, readTaskLists.size());

        int id = readTaskLists.get(0).getId();
        taskListDao.deleteById(id);
    }

    @Test
    void testTaskListDaoSaveWithTasks() {
        Task task = new Task("Test: Learn Hibernate", 14);
        Task task2 = new Task("Test: Write some entities", 3);

        TaskFinancialDetails tfd = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);

        task.setTaskFinancialDetails(tfd);
        task2.setTaskFinancialDetails(tfd2);

        TaskList taskList = new TaskList("ToDo","ToDo tasks");
        taskList.getTasks().add(task);
        taskList.getTasks().add(task2);
        task.setTaskList(taskList);
        task.setTaskList(taskList);

        taskListDao.save(taskList);
        int id = taskList.getId();

        assertNotEquals(0, id);

        taskListDao.deleteById(id);
    }
}
