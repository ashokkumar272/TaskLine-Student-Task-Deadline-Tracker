package com.example.taskline.repository;

import com.example.taskline.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByDeadlineBetween(LocalDateTime start, LocalDateTime end);
}
