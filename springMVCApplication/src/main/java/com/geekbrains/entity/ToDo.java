package com.geekbrains.entity;

import java.time.LocalDateTime;

public class ToDo {

    private Long id;
    private String description;
    private LocalDateTime deadline;

    public ToDo () {
    }

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public LocalDateTime getDeadline () {
        return deadline;
    }

    public void setDeadline (LocalDateTime deadline) {
        this.deadline = deadline;
    }


}
