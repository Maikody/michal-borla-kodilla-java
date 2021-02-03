package com.example.kodilla.hibernate.tasklist;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TASKLISTS")
public class TaskList {
    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID", unique=true)
    private int id;
    @Column(name = "LISTNAME")
    private String listName;
    @Column(name = "DESCRIPTION")
    private String description;

    public TaskList() {
    }

    public TaskList(String listName, String description) {
        this.listName = listName;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getListName() {
        return listName;
    }

    public String getDescription() {
        return description;
    }
}
