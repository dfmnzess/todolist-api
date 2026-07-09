package com.davi.todolist.dto;

import com.davi.todolist.model.Priority;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TaskResponse {

    private Long id;
    private String title;
    private String description;
    private boolean completed;
    private Priority priority;
    private LocalDate dueDate;
    private LocalDateTime createdAt;

    public TaskResponse(Long id, String title, String description, boolean completed,
                        Priority priority, LocalDate dueDate, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.priority = priority;
        this.dueDate = dueDate;
        this.createdAt = createdAt;
    }

    // getters
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public boolean isCompleted() { return completed; }
    public Priority getPriority() { return priority; }
    public LocalDate getDueDate() { return dueDate; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}