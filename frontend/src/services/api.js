import axios from "axios"

const API = axios.create({
    baseURL: "https://interview-analyzer-8c77.onrender.com"
});

export const getAccuracy = (userId) => 

    API.get(`/analytics/accuracy/${userId}`);

export const getAverageTime = (userId) => 

    API.get(`/analytics/averageTime/${userId}`);


export const getTopTopic = (userId) =>

    API.get(`/analytics/topTopic/${userId}`);


export const getTopicAccuracy = (userId) =>

    API.get(`/analytics/topicAccuracy/${userId}`);


export const getRecentAttempts = (userId) => {

   return API.get(`/analytics/recentAttempts/${userId}`);
}

   export const getWeakTopics = (userId) => 

     API.get(`/analytics/weakTopics/${userId}`);

   export const getStrongTopics = (userId) =>
    
    API.get(`/analytics/strongTopics/${userId}`);
   

