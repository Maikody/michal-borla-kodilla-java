package com.kodilla.stream.portfolio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTestSuite {
    public Board project;

    @BeforeEach
    public void setup(){
        project = prepareTestData();
    }

    @Test
    void testAddTaskList() {
        assertEquals(3, project.getTaskLists().size());
    }

    @Test
    public void testAddTaskListFindUsersTasks(){
        User user = new User("developer1", "John Smith");
        List<Task> tasks = project.getTaskLists().stream()
                .flatMap(list -> list.getTasks().stream())
                .filter(task -> task.getAssignedUser().equals(user))
                .collect(Collectors.toList());

        assertEquals(2, tasks.size());
        assertEquals(user, tasks.get(0).getAssignedUser());
        assertEquals(user, tasks.get(1).getAssignedUser());
    }

    @Test
    public void testAddTaskListFindOutdatedTasks(){
        List<TaskList> undoneTasks = new ArrayList<>();
        undoneTasks.add(new TaskList("To do"));
        undoneTasks.add(new TaskList("In progress"));
        List<Task> tasks =  project.getTaskLists().stream()
                .filter(undoneTasks::contains)
                .flatMap(taskList -> taskList.getTasks().stream())
                .filter(task -> task.getDeadline().isBefore(LocalDate.now()))
                .collect(Collectors.toList());

        assertEquals(1, tasks.size());
        assertEquals("HQLs for analysis", tasks.get(0).getTitle());
    }

    @Test
    public void testAddTaskListsFindLongTasks(){
        List<TaskList> inProgressTasks = new ArrayList<>();
        inProgressTasks.add(new TaskList("In progress"));
        long longTasks = project.getTaskLists().stream()
                .filter(inProgressTasks::contains)
                .flatMap(taskList -> taskList.getTasks().stream())
                .map(Task::getCreated)
                .filter(date -> date.compareTo(LocalDate.now().minusDays(10)) <=0)
                .count();

        assertEquals(2, longTasks);
    }

    @Test
    public void testAddTaskListAverageWorkingOnTask(){
        List<TaskList> inProgressTasks = new ArrayList<>();
        inProgressTasks.add(new TaskList("In progress"));
        List<Long> numberOfDays = project.getTaskLists().stream()
                .filter(inProgressTasks::contains)
                .flatMap(taskList -> taskList.getTasks().stream())
                .map(task -> DAYS.between(task.getCreated(),LocalDate.now()))
                .collect(Collectors.toList());

        double average = numberOfDays.stream()
                .mapToDouble(Long::doubleValue)
                .average()
                .getAsDouble();

        assertEquals(3, numberOfDays.size());
        assertEquals(10, average,0.01);
    }

    private Board prepareTestData() {
        User user1 = new User("developer1", "John Smith");
        User user2 = new User("projectmanager1", "Nina White");
        User user3 = new User("developer2", "Emilia Stephanson");
        User user4 = new User("developer3", "Konrad Bridge");

        Task task1 = new Task("Microservice for taking temperature",
                "Write and test the microservice taking\n" +
                        "the temperature from external service",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(30));
        Task task2 = new Task("HQLs for analysis",
                "Prepare some HQL queries for analysis",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().minusDays(5));
        Task task3 = new Task("Temperatures entity",
                "Prepare entity for temperatures",
                user3,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(15));
        Task task4 = new Task("Own logger",
                "Refactor company logger to meet our needs",
                user3,
                user2,
                LocalDate.now().minusDays(10),
                LocalDate.now().plusDays(25));
        Task task5 = new Task("Optimize searching",
                "Archive data searching has to be optimized",
                user4,
                user2,
                LocalDate.now(),
                LocalDate.now().plusDays(5));
        Task task6 = new Task("Use Streams",
                "use Streams rather than for-loops in predictions",
                user4,
                user2,
                LocalDate.now().minusDays(15),
                LocalDate.now().minusDays(2));

        TaskList taskListToDo = new TaskList("To do");
        taskListToDo.addTask(task1);
        taskListToDo.addTask(task3);
        TaskList taskListInProgress = new TaskList("In progress");
        taskListInProgress.addTask(task5);
        taskListInProgress.addTask(task4);
        taskListInProgress.addTask(task2);
        TaskList taskListDone = new TaskList("Done");
        taskListDone.addTask(task6);

        Board project = new Board("Project Weather Prediction");
        project.addTaskList(taskListToDo);
        project.addTaskList(taskListInProgress);
        project.addTaskList(taskListDone);
        return project;
    }
}

