# Interview Performance Analyzer

A Backend system that tracks coding practice performance
and provides analytics such as accuracy, weak topics,
average solving time, and recent attempts.

## Tech Stack
Java
Spring Boot
Spring Data JPA
MySQL
Lombok

## Features
User management
Topic and question tracking
Attempt recording
Performance analytics
DTO-based responses
Global exception handling
Validation

## APIs
POST /users
POST /topics
POST /questions
POST /attempts

GET /analytics/accuracy/{userId}
GET /analytics/topic-accuracy/{userId}
GET /analytics/average-time/{userId}
GET /analytics/weak-topics/{userId}
GET /analytics/strong-topics/{userId}
GET /analytics/top-topic/{userId}
GET /analytics/recent-attempts/{userId}