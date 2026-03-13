package com.sivacodes.interview_analyzer.service;

import com.sivacodes.interview_analyzer.repository.TopicRepository;
import com.sivacodes.interview_analyzer.exception.ResourceNotFoundException;
import com.sivacodes.interview_analyzer.model.Topic;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
    
private final TopicRepository topicRepository;

public TopicService(TopicRepository topicRepository) {
    this.topicRepository = topicRepository;
}
 

  public List<Topic> getAllTopics() {
    return topicRepository.findAll();
  }
public Topic saveTopic(Topic topic) {
    return topicRepository.save(topic);
}

public Topic updateTopic(Long id, Topic topic) {
    topic.setId(id);
    return topicRepository.save(topic);
}

public void deleteTopic(Long id) {
    topicRepository.deleteById(id);
}

public Topic getNoTopic(Long id) {
    return topicRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Topic Not Found"));
}
}
