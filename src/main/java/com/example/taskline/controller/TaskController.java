package com.example.taskline.controller;

import com.example.taskline.dto.TaskCreateRequest;
import com.example.taskline.dto.TaskResponse;
import com.example.taskline.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<TaskResponse> createTask(@Valid @RequestBody TaskCreateRequest request) {
        TaskResponse response = taskService.createTask(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<TaskResponse>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @PutMapping("/{id}/done")
    public ResponseEntity<TaskResponse> markAsDone(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.markAsDone(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/upcoming")
    public ResponseEntity<List<TaskResponse>> getUpcomingTasks(
            @RequestParam(defaultValue = "48") int hours) {
        return ResponseEntity.ok(taskService.getUpcomingTasks(hours));
    }
}
