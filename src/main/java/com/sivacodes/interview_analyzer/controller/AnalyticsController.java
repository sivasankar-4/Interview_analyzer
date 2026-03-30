package com.sivacodes.interview_analyzer.controller;

import com.sivacodes.interview_analyzer.dto.RecentAttemptDTO;
//import com.sivacodes.interview_analyzer.model.Attempt;
import com.sivacodes.interview_analyzer.service.AnalyticsService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sivacodes.interview_analyzer.service.AttemptService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.*;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/analytics")
public class AnalyticsController {
    

    private final AttemptService attemptService;

    private final AnalyticsService analyticsService;

    
    @GetMapping("/accuracy/{userId}")
    public double getAccuracy(@PathVariable Long userId) {
        return attemptService.calculateAccuracy(userId);
    }

    @GetMapping("/topicAccuracy/{userId}")
    public HashMap<String, Double> getTopicAccuracy(@PathVariable Long userId) {
        return analyticsService.calculateTopicAccuracy(userId);
    }

    @GetMapping("/averageTime/{userId}")
    public double getAverageTime(@PathVariable Long userId) {
        return analyticsService.calculateAverageTime(userId);
    }
    @GetMapping("/weakTopics/{userId}")
    public List<String> getWeakTopics(@PathVariable Long userId) {
        return analyticsService.findWeakTopics(userId);
    }

    @GetMapping("/strongTopics/{userId}")
    public List<String> getStrongTopics(@PathVariable Long userId) {
        return analyticsService.findStrongTopics(userId);
    }
    
    @GetMapping("/topTopic/{userId}")
    public Map<String, Object> getTopTopic(@PathVariable Long userId) {
        return analyticsService.findTopTopic(userId);
    }

    @GetMapping("/recentAttempts/{userId}")
    public List<RecentAttemptDTO> getRecentAttempts(@PathVariable Long userId) {
        return analyticsService.getRecentAttempts(userId);
    }
}
