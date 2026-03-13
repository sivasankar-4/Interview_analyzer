package com.sivacodes.interview_analyzer.service;


import com.sivacodes.interview_analyzer.model.Attempt;
import com.sivacodes.interview_analyzer.repository.AttemptRepository;


import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AttemptService {
    
   
    private final AttemptRepository attemptRepository;

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
