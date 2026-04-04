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



@Service
@RequiredArgsConstructor
public class AttemptService {
    
    
    private final  AttemptRepository attemptRepository;
    
    
     private final UserRepository userRepository;
    

     private final QuestionRepository questionRepository;

    // public AttemptService(AttemptRepository attemptRepository){
    //     this.attemptRepository = attemptRepository;
    // }

    
    public java.util.List<Attempt> getAllAttempts() {
        return attemptRepository.findAll();
    }

    public List<Attempt> getAttemptsByUserId(Long userId) {
        return attemptRepository.findByUserId(userId);
    }

    public Attempt saveAttempt(Attempt attempt) {
        
       if(attempt.getUser() == null || attempt.getUser().getId() == null){
        throw new RuntimeException("User Id is required");
       }

       if(attempt.getQuestion() == null || attempt.getQuestion().getId() == null){
        throw new RuntimeException("Question Id is required");
       }
       Long userId = attempt.getUser().getId();
       Long questionId = attempt.getQuestion().getId();

       User user = userRepository.findById(userId)
                   .orElseThrow(() -> new RuntimeException("user not found with id: " + userId));

       Question question = questionRepository.findById(questionId)
                           .orElseThrow(() -> new RuntimeException("Question not found with id:" + questionId));

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
