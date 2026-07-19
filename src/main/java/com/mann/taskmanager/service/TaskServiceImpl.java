package com.mann.taskmanager.service;

import com.mann.taskmanager.entity.User;
import com.mann.taskmanager.exception.ResourceNotFoundException;
import com.mann.taskmanager.entity.Task;
import com.mann.taskmanager.repository.TaskRepository;
import com.mann.taskmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<Task> getAllTasks() {
        String userId = getCurrentUserId();
        return taskRepository.findByUserid(userId);
    }

    private String getCurrentUserId() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + username));
        return user.getId();
    }

    @Override
    public Task getTaskById(String id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));

        String userId = getCurrentUserId();
        if (!task.getUserid().equals(userId)) {
            throw new ResourceNotFoundException("Task not found with id: " + id);
        }

        return task;
    }

    @Override
    public Task createTask(Task task) {
        String userId = getCurrentUserId();
        task.setUserid(userId);
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(String id, Task taskDetails) {
        Task existingTask = getTaskById(id); // reusing our own method

        existingTask.setTitle(taskDetails.getTitle());
        existingTask.setDescription(taskDetails.getDescription());
        existingTask.setCompleted(taskDetails.isCompleted());

        return taskRepository.save(existingTask);
    }

    @Override
    public void deleteTask(String id) {
        Task existingTask = getTaskById(id); // throws exception if not found

        taskRepository.delete(existingTask);
    }
}
