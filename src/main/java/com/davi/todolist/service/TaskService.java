package com.davi.todolist.service;

import com.davi.todolist.dto.TaskRequest;
import com.davi.todolist.dto.TaskResponse;
import com.davi.todolist.model.Priority;
import com.davi.todolist.model.Task;
import com.davi.todolist.repository.TaskRepository;
import org.springframework.stereotype.Service;
import com.davi.todolist.exception.TaskNotFoundException;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskResponse create(TaskRequest request) {
        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setPriority(request.getPriority());
        task.setDueDate(request.getDueDate());

        Task saved = taskRepository.save(task);
        return toResponse(saved);
    }

    public List<TaskResponse> findAll() {
        return taskRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    public TaskResponse findById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        return toResponse(task);
    }

    public TaskResponse update(Long id, TaskRequest request) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setPriority(request.getPriority());
        task.setDueDate(request.getDueDate());

        return toResponse(taskRepository.save(task));
    }

    public TaskResponse markAsCompleted(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        task.setCompleted(true);
        return toResponse(taskRepository.save(task));
    }

    public void delete(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new TaskNotFoundException(id);
        }
        taskRepository.deleteById(id);
    }

    public List<TaskResponse> findByPriority(Priority priority) {
        return taskRepository.findByPriority(priority).stream()
                .map(this::toResponse)
                .toList();
    }

    private TaskResponse toResponse(Task task) {
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.isCompleted(),
                task.getPriority(),
                task.getDueDate(),
                task.getCreatedAt()
        );
    }
}