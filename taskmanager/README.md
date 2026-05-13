# Task Manager API

A Spring Boot REST API for managing tasks using MongoDB.

## Tech Stack
- Java 21
- Spring Boot
- MongoDB
- Maven
- Lombok
- Postman

## Features
- Create Task
- Get All Tasks
- Get Task By ID
- Update Task
- Delete Task

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /tasks | Get all tasks |
| GET | /tasks/{id} | Get task by ID |
| POST | /tasks | Create new task |
| PUT | /tasks/{id} | Update task |
| DELETE | /tasks/{id} | Delete task |

## Running the Project

### Start MongoDB

Run MongoDB manually:

```bash
mongod
```

### Run Spring Boot App

```bash
./mvnw spring-boot:run
```

## Project Progress

### Day 1
- Spring Boot project setup
- Maven configuration
- REST API structure created
- CRUD endpoints implemented

### Day 2
- Migrated from JPA/MySQL to MongoDB
- Configured MongoDB locally
- Fixed Java/Maven version conflicts
- Integrated Lombok
- Tested APIs using Postman

### Current Status
- CRUD APIs fully functional
- MongoDB connected successfully
- GET, POST, PUT, DELETE working