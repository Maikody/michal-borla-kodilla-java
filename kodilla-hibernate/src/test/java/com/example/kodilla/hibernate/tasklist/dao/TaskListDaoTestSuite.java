package com.example.kodilla.hibernate.tasklist.dao;

import com.example.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
