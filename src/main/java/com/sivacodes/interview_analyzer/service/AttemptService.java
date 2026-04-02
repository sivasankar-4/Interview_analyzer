package com.sivacodes.interview_analyzer.service;


import com.sivacodes.interview_analyzer.model.Attempt;
import com.sivacodes.interview_analyzer.model.Question;
import com.sivacodes.interview_analyzer.model.User;
import com.sivacodes.interview_analyzer.repository.AttemptRepository;
import com.sivacodes.interview_analyzer.repository.QuestionRepository;
import com.sivacodes.interview_analyzer.repository.UserRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AttemptService {
    
   
    private  AttemptRepository attemptRepository;

    private  UserRepository userRepository;

    private  QuestionRepository questionRepository;

    public AttemptService(AttemptRepository attemptRepository) {
        this.attemptRepository = attemptRepository;
        
    }
    public java.util.List<Attempt> getAllAttempts() {
        return attemptRepository.findAll();
    }

    public List<Attempt> getAttemptsByUserId(Long userId) {
        return attemptRepository.findByUserId(userId);
    }

    public Attempt saveAttempt(Attempt attempt) {
        
        Long userId = attempt.getUser().getId();
        Long questionId = attempt.getQuestion().getId();

        User user = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("User not found"));

        Question question = questionRepository.findById(questionId)
                            .orElseThrow(() -> new RuntimeException("Question not found"));

        attempt.setUser(user);
        attempt.setQuestion(question);
          
        return attemptRepository.save(attempt);
    }

    public double calculateAccuracy(Long userId) {
        long total = attemptRepository.countByUserId(userId);
        long solved = attemptRepository.countByUserIdAndSolvedTrue(userId);
        
        if(total == 0) {
            return 0.0;
        }
        return (solved * 100.0)/total;
    }

}
