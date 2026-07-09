package com.davi.todolist.repository;

import com.davi.todolist.model.Priority;
import com.davi.todolist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByCompleted(boolean completed);

    List<Task> findByPriority(Priority priority);
}