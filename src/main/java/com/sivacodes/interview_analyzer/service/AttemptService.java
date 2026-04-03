package com.sivacodes.interview_analyzer.service;


import com.sivacodes.interview_analyzer.model.Attempt;
import com.sivacodes.interview_analyzer.model.Question;
import com.sivacodes.interview_analyzer.model.User;
import com.sivacodes.interview_analyzer.repository.AttemptRepository;
import com.sivacodes.interview_analyzer.repository.QuestionRepository;
import com.sivacodes.interview_analyzer.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor

@Service
public class AttemptService {
    
    
    private final  AttemptRepository attemptRepository;
    
    
    private final UserRepository userRepository;
    

    private final QuestionRepository questionRepository;

    
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
