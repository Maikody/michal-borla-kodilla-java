package com.kodilla.spring.portfolio;

public class Board {

    private final TaskList toDoList;
    private final TaskList inProgressList;
    private final TaskList doneList;

    public Board(TaskList createToDoList, TaskList createInProgressList, TaskList createDoneList) {
        this.toDoList = createToDoList;
        this.inProgressList = createInProgressList;
        this.doneList = createDoneList;
    }

    public void addTask(String task, TaskList list) {
        list.addTask(task);
    }

    public TaskList getToDoList() {
        return toDoList;
    }

    public TaskList getInProgressList() {
        return inProgressList;
    }

    public TaskList getDoneList() {
        return doneList;
    }

}
