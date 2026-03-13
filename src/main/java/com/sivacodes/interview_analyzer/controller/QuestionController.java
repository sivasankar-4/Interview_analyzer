package com.sivacodes.interview_analyzer.controller;

import com.sivacodes.interview_analyzer.model.Question;
import com.sivacodes.interview_analyzer.service.QuestionService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/Questions")
public class QuestionController {
    

    private final QuestionService questionService;

     
     
     @GetMapping("/getAllQuestions")
     public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }
    @PostMapping("/createQuestion")
    public Question createQuestion(@RequestBody Question question) {
        return questionService.saveQuestion(question);
    }
    
    @PutMapping("/updateQuestion/{id}")
    public Question updateQuestion(@PathVariable Long id, @RequestBody Question question) {
        question.setId(id);
        return questionService.saveQuestion(question);
    }
    @DeleteMapping("/deleteQuestion/{id}")
    public void deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
    }
    
    @GetMapping("/getNoQuestion/{id}")
    public Question getNoQuestion(@PathVariable Long id) {
        return questionService.getNoQuestion(id);
    }
}
