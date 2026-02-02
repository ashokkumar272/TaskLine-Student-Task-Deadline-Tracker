package com.example.taskline.service;

import com.example.taskline.dto.TaskCreateRequest;
import com.example.taskline.dto.TaskResponse;

import java.util.List;

public interface TaskService {

    TaskResponse createTask(TaskCreateRequest request);

    List<TaskResponse> getAllTasks();

    TaskResponse getTaskById(Long id);

    TaskResponse markAsDone(Long id);

    void deleteTask(Long id);

    List<TaskResponse> getUpcomingTasks(int hours);
}
