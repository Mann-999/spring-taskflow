package com.mann.taskmanager.repository;

import com.mann.taskmanager.entity.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//Spring Data JPA sees this interface and automatically generates all the complex SQL code
@Repository
public interface TaskRepository extends MongoRepository<Task, String> {
}