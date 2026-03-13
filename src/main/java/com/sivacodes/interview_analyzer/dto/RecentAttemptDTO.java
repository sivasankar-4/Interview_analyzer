package com.sivacodes.interview_analyzer.dto;

public class RecentAttemptDTO {
    

   private String question;

   private String topic;

   private boolean solved;

   private int timeTaken;

   public RecentAttemptDTO(String question, String topic, boolean solved, int timeTaken) {
        this.question = question;
        this.topic = topic;
        this.solved = solved;
        this.timeTaken = timeTaken;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }

    public int getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(int timeTaken) {
        this.timeTaken = timeTaken;
    }
}
