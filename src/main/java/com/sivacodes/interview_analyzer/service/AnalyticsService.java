package com.sivacodes.interview_analyzer.service;


import com.sivacodes.interview_analyzer.dto.RecentAttemptDTO;
import com.sivacodes.interview_analyzer.model.Attempt;
import com.sivacodes.interview_analyzer.repository.AttemptRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class AnalyticsService {
    
       private final AttemptRepository attemptRepository;

       public AnalyticsService(AttemptRepository attemptRepository) {
        this.attemptRepository = attemptRepository;
       
       }
   // Method to calculate accuracy per topic for a user
   //it iterates through all attempts of the user and counts total attempts 
   // and solved attempts for each topic. Then it calculates accuracy as (solved/total)*100 
   // for each topic and returns a map of topic names to their accuracy percentages.
   //it uses two HashMaps to keep track of total attempts and solved attempts for each topic. 
   // Finally, it calculates the accuracy for each topic and returns it in a new HashMap.
        public HashMap<String, Double> calculateTopicAccuracy(Long userId) {
       List<Attempt> attempts = attemptRepository.findByUserId(userId);

       HashMap<String, Integer> total = new HashMap<>();
       HashMap<String, Integer> solved = new HashMap<>();
       
       for(Attempt attempt : attempts) {
         String topicName = attempt.getQuestion().getTopic().getName();
            total.put(topicName, total.getOrDefault(topicName, 0) + 1);

            if(attempt.isSolved()) {
                solved.put(topicName, solved.getOrDefault(topicName, 0) + 1);
            }
       }
       
       HashMap<String, Double> topicAccuracy = new HashMap<>();
       for(String topic : total.keySet()) {
           int solvedCount = solved.getOrDefault(topic, 0);
           int totalCount = total.get(topic);
           if(totalCount == 0) continue;
           double accuracy = (solvedCount * 100.0) / totalCount;
           accuracy = Math.round(accuracy *100.0)/100.0;
           topicAccuracy.put(topic, accuracy);
       }
       
       return topicAccuracy;
    }

    List<Attempt> getAttemptsByUserId(Long userId) {
        return attemptRepository.findByUserId(userId);
    }
// Method to calculate average time taken per question for a user
//it retrieves all attempts for the user, sums up the time taken for each attempt, 
// and divides by the total number of attempts to get the average time.
    public double calculateAverageTime(Long userId) {

        List<Attempt> attempts = attemptRepository.findByUserId(userId);

        if (attempts.isEmpty()) {
            return 0.0;
        }
        int totalTime = 0;

        for(Attempt attempt : attempts) {

            totalTime +=attempt.getTimetaken();
        }

        double avg =  (double) totalTime / attempts.size();

        return Math.round(avg *100)/100;
    }
    // Method to find weak topics based on accuracy
    //it checks each topic accuracy if accuracy < 50% then add it to weakTopicsList;
    public List<String> findWeakTopics(Long userId) {
        HashMap<String, Double> topicAccuracy = calculateTopicAccuracy(userId);
        List<String> weakTopics = new ArrayList<>();
         
        for (Map.Entry<String, Double> entry : topicAccuracy.entrySet()) {
            if (entry.getValue() < 50.0) { // Threshold for weak topics
                weakTopics.add(entry.getKey());
            }
        }

        return weakTopics;
    }
    // Method to find strong topics based on accuracy
    //it checks each topic accuracy if accuracy >= 80% then add it to strongTopicsList;
    
    public List<String> findStrongTopics(Long userId) {

        HashMap<String, Double> topicAccuracy = calculateTopicAccuracy(userId);

        List<String> StrongTopics = new ArrayList<>();

        for(Map.Entry<String, Double> entry : topicAccuracy.entrySet()) {
            if(entry.getValue() >= 80.0) {
                StrongTopics.add(entry.getKey());
            }
       }
        return StrongTopics;
    }
    // Method to find the topic with the most attempts for a user
    //it retrieves all attempts for the user, counts the number of attempts for each topic,
// and identifies the topic with the highest count. It returns a map containing the top topic and the number of attempts.
    public HashMap<String, Object> findTopTopic(Long userId) {

        List<Attempt> attempts = attemptRepository.findByUserId(userId);

        HashMap<String , Integer> topicCount = new HashMap<>();

        for(Attempt attempt : attempts) {

            String topic = attempt.getQuestion().getTopic().getName();

            topicCount.put(topic, topicCount.getOrDefault(topic,0)+1);
        }
        String topTopic = null;
        int maxAttempts = 0;

        for(Map.Entry<String, Integer> entry : topicCount.entrySet()) {

            if(entry.getValue() > maxAttempts) {
                maxAttempts = entry.getValue();
                topTopic = entry.getKey();
            }
        }
        HashMap<String, Object> result = new HashMap<>();

        result.put("topTopic", topTopic);
        result.put("attempts",maxAttempts);

        return result;
    }

    // public List<Attempt> getRecentAttempts(Long userId) {
    //     return attemptRepository.findTop5ByUserIdOrderByAttemptDateDesc(userId);
    // }
   
    public List<RecentAttemptDTO> getRecentAttempts(Long userId) {

        List<Attempt> attempts = attemptRepository.findTop5ByUserIdOrderByAttemptDateDesc(userId);
        List<RecentAttemptDTO> result = new ArrayList<>();

        for(Attempt attempt : attempts) {
           String question = attempt.getQuestion().getTitle();
           String topic = attempt.getQuestion().getTopic().getName();

           result.add(new RecentAttemptDTO(
                question,
                topic,
                attempt.isSolved(),
                attempt.getTimetaken()
           ));
        }
        return result;
    }
 

}
