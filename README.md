# Task Manager API

A Spring Boot REST API for managing tasks with JWT authentication using MongoDB.

## Tech Stack
- Java 21
- Spring Boot
- Spring Security
- JWT (JSON Web Tokens)
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
- User Registration
- User Login with JWT

## API Endpoints

### Auth
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /auth/register | Register new user |
| POST | /auth/login | Login and get JWT token |
| GET | /auth/me | Get current logged in user |

### Tasks
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /tasks | Get all tasks |
| GET | /tasks/{id} | Get task by ID |
| POST | /tasks | Create new task |
| PUT | /tasks/{id} | Update task |
| DELETE | /tasks/{id} | Delete task |

## Important Annotations used in this project
### @RestController
- tells Spring this class handles HTTP requests and returns data as JSON instead of HTML pages.
- Internally, it is a shorthand for @Controller and @ResponseBody.
- @Controller handles web request.
- @ResponseBody return value goes directly into HTTP response body.
### @RequestMapping
- sets the base API path for the whole controller.
```
    @RequestMapping ("/api/users")
```
### Specific HTTP endpoints
- ### @GetMapping("/{id}")
- ### @PostMapping
- ### @PutMapping("/{id}")
- ### @DeleteMapping("/{id}")
```
  @RequestMapping ("/api/users")
  public class UserController {
      @GetMapping("/{id}")
      public String getUser() {
          return "user";
      }
  }
```

## Running the Project

### Start MongoDB

```bash
cd "C:\Program Files\MongoDB\Server\8.0\bin"
mongod.exe
```

### Run Spring Boot App

```bash
./mvnw spring-boot:run
```

### Authentication
Register a user then login to get a JWT token. Include the token in subsequent requests:
```
Authorization: Bearer <your_token>
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

### Day 3
- Created `User` entity with MongoDB mapping
- Created `UserRepository` with `findByUsername` query

### Day 4
- Added JWT dependency to `pom.xml`
- Built `JwtUtil` — token generation and validation
- Built `SecurityConfig` — route protection and stateless session policy

### Day 5
- Built `CustomUserDetailsService` — loads user from MongoDB for Spring Security
- Built `JwtFilter` — intercepts requests and validates JWT tokens
- Plugged `JwtFilter` into `SecurityConfig`
- Built `AuthController` — `/auth/register` and `/auth/login` endpoints
- Passwords stored as BCrypt hash
- JWT token returned on successful login

### Day 6
- Built `GET /auth/me` endpoint — returns current user info from JWT token
- Fixed `permitAll()` scope — only `/auth/register` and `/auth/login` are public
- Fixed `JwtFilter` to handle expired tokens gracefully with try-catch
- Learned: `@AuthenticationPrincipal` only works on `authenticated()` routes

## Current Status
- CRUD APIs fully functional
- MongoDB connected successfully
- JWT Authentication working
- Register and Login endpoints tested via Postman