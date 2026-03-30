package com.sivacodes.interview_analyzer.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Attempts")
public class Attempt {
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean solved;
    
    @Column(name = "time_taken")
    @JsonProperty("timeTaken")
    private Integer timetaken;

    private Integer attempts;
    
    private LocalDateTime attemptDate;
    
@ManyToOne
@JoinColumn(name = "user_id")
private User user;

@ManyToOne
@JoinColumn(name = "question_id")
private Question question;



    public Attempt() {
    }
  
    public Attempt(Long id, boolean solved, int timetaken, int attempts, LocalDateTime attemptDate) {
        this.id = id;
        this.solved = solved;
        this.timetaken = timetaken;
        this.attempts = attempts;
        this.attemptDate = attemptDate;
    }


    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }



    public boolean isSolved() {
        return solved;
    }



    public void setSolved(boolean solved) {
        this.solved = solved;
    }



    public Integer getTimetaken() {
        return timetaken;
    }



    public void setTimetaken(int timetaken) {
        this.timetaken = timetaken;
    }



    public Integer getAttempts() {
        return attempts;
    }



    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }



    public LocalDateTime getAttemptDate() {
        return attemptDate;
    }



    public void setAttemptDate(LocalDateTime attemptDate) {
        this.attemptDate = attemptDate;
    }



    public User getUser() {
        return user;
    }



    public void setUser(User user) {
        this.user = user;
    }



    public Question getQuestion() {
        return question;
    }



    public void setQuestion(Question question) {
        this.question = question;
    }

}