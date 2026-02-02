package com.example.springOne.service;

import com.example.springOne.dto.TaskCreateRequest;
import com.example.springOne.dto.TaskResponse;

import java.util.List;

public interface TaskService {

    TaskResponse createTask(TaskCreateRequest request);

    List<TaskResponse> getAllTasks();

    TaskResponse getTaskById(Long id);

    TaskResponse markAsDone(Long id);

    void deleteTask(Long id);

    List<TaskResponse> getUpcomingTasks(int hours);
}
