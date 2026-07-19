package com.mann.taskmanager.controller;

import com.mann.taskmanager.entity.Task;
import com.mann.taskmanager.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> getAll() {
        List<Task> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable String id) {
        Task task = taskService.getTaskById(id);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Task> create(@Valid @RequestBody Task task) {
        Task newTask = taskService.createTask(task);
        return new ResponseEntity<>(newTask, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> update(@PathVariable String id, @Valid @RequestBody Task taskDetails) {
        Task updatedTask = taskService.updateTask(id, taskDetails);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        taskService.deleteTask(id);
        return new ResponseEntity<>("Task " + id + " has been deleted!", HttpStatus.OK);
    }
}