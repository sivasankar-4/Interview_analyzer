package com.sivacodes.interview_analyzer.controller;

import com.sivacodes.interview_analyzer.model.Attempt;  
import com.sivacodes.interview_analyzer.service.AttemptService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/Attempts")
public class AttemptController {
    
    private final AttemptService attemptService;

    
    @GetMapping("/getAllAttempts")
    public List<Attempt> getAllAttempts() {
        return attemptService.getAllAttempts();
    }

    @GetMapping("/getAttempts/{userId}")
    public List<Attempt> getAttemptsByUserId(@PathVariable Long userId) {
        return attemptService.getAttemptsByUserId(userId);
    }
    
    @PostMapping("/createAttempt")
    public Attempt createAttempt(@RequestBody Attempt attempt) {
        return attemptService.saveAttempt(attempt);
    }
    
    // public Attempt updateAttempt(@PathVariable Long userId @RequestBody Attempt attempt) {
    //     Attempt.setId(id);
    //     return attemptService.saveAttempt(attempt);
    // }

}
