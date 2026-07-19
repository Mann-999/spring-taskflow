package com.mann.taskmanager.service;

import com.mann.taskmanager.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();
    Task getTaskById(String id);
    Task createTask(Task task);
    Task updateTask(String id, Task taskDetails);
    void deleteTask(String id);
}
