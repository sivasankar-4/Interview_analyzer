package com.sivacodes.interview_analyzer.controller;

import com.sivacodes.interview_analyzer.model.Topic;
import com.sivacodes.interview_analyzer.service.TopicService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/Topics")
public class TopicController {
      
    private final TopicService topicService;

    
    @GetMapping("/getTopics")
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }
    @PostMapping("/createTopics")
    public Topic createTopic(@RequestBody Topic topic) {
        return topicService.saveTopic(topic);
    }
    @PutMapping("/updateTopics/{id}")
    public Topic updateTopic(@PathVariable Long id, @RequestBody Topic topic) {
        topic.setId(id);
        return topicService.saveTopic(topic);
    }
    @DeleteMapping("/deleteTopics/{id}")
    public void deleteTopic(@PathVariable Long id) {
        topicService.deleteTopic(id);
    }

    @GetMapping("/getNoTopic/{id}")
    public Topic getNoTopic(@PathVariable Long id) {
        return topicService.getNoTopic(id);
    }
}
