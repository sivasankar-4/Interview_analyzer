package com.sivacodes.interview_analyzer.service;

import com.sivacodes.interview_analyzer.exception.ResourceNotFoundException;
import com.sivacodes.interview_analyzer.model.Question;
import org.springframework.stereotype.Service;

import com.sivacodes.interview_analyzer.repository.QuestionRepository;

import java.util.List;
@Service

public class QuestionService {
    
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }
    
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }
    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }
    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }

    public Question getNoQuestion(Long id) {

        return questionRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Question not found"));
    }
}
