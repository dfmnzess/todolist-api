package com.davi.todolist.exception;

public class TaskNotFoundException extends RuntimeException {

    public TaskNotFoundException(Long id) {
        super("Tarefa com id " + id + " não encontrada");
    }
}