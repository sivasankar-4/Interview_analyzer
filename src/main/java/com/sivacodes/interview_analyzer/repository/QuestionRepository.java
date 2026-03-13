package com.sivacodes.interview_analyzer.repository;

import com.sivacodes.interview_analyzer.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long>{
    
}
