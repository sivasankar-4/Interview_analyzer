package com.sivacodes.interview_analyzer.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Questions")
public class Question {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String title;

    private String difficulty;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    public Question() {
    }
    

    public Question(Long id,String title, String difficulty){
        this.id = id;
        this.title = title;
        this.difficulty = difficulty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public Topic getTopic() {
    return topic;
   }

    public void setTopic(Topic topic) {
    this.topic = topic;
   }
}
