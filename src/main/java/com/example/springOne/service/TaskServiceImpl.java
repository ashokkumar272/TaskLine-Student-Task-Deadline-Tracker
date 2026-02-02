package com.example.springOne.service;

import com.example.springOne.dto.TaskCreateRequest;
import com.example.springOne.dto.TaskResponse;
import com.example.springOne.entity.Task;
import com.example.springOne.entity.TaskStatus;
import com.example.springOne.exception.ResourceNotFoundException;
import com.example.springOne.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public TaskResponse createTask(TaskCreateRequest request) {
        Task task = new Task(
                request.getTitle(),
                request.getDescription(),
                request.getDeadline()
        );
        Task savedTask = taskRepository.save(task);
        return TaskResponse.fromEntity(savedTask);
    }

    @Override
    public List<TaskResponse> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(TaskResponse::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public TaskResponse getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
        return TaskResponse.fromEntity(task);
    }

    @Override
    public TaskResponse markAsDone(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
        task.setStatus(TaskStatus.DONE);
        Task updatedTask = taskRepository.save(task);
        return TaskResponse.fromEntity(updatedTask);
    }

    @Override
    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new ResourceNotFoundException("Task not found with id: " + id);
        }
        taskRepository.deleteById(id);
    }

    @Override
    public List<TaskResponse> getUpcomingTasks(int hours) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime end = now.plusHours(hours);
        return taskRepository.findByDeadlineBetween(now, end)
                .stream()
                .map(TaskResponse::fromEntity)
                .collect(Collectors.toList());
    }
}
