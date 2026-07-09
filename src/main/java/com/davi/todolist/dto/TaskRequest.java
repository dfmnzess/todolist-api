package com.davi.todolist.dto;

import com.davi.todolist.model.Priority;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class TaskRequest {

    @NotBlank(message = "O título é obrigatório")
    private String title;

    private String description;

    private Priority priority;

    private LocalDate dueDate;

    // getters e setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Priority getPriority() { return priority; }
    public void setPriority(Priority priority) { this.priority = priority; }

    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }
}
