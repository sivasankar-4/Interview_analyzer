package com.sivacodes.interview_analyzer.service;

import org.springframework.stereotype.Service;
import com.sivacodes.interview_analyzer.repository.UserRepository;
import com.sivacodes.interview_analyzer.exception.ResourceNotFoundException;
import com.sivacodes.interview_analyzer.model.User;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
         this.userRepository = userRepository;
    }
    
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    public com.sivacodes.interview_analyzer.model.User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User updateUser(Long id, User user) {
        return userRepository.save(user);
    }
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
    
    public User getNouser(Long Id) {
    return userRepository.findById(Id)
                 .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + Id)); 
    }   
}

