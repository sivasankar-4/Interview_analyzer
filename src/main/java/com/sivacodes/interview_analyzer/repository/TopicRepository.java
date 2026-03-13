package com.sivacodes.interview_analyzer.repository;

import com.sivacodes.interview_analyzer.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TopicRepository extends JpaRepository<Topic, Long> {
    
}   
