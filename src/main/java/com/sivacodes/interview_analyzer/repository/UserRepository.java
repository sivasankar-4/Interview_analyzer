package com.sivacodes.interview_analyzer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivacodes.interview_analyzer.model.User;
public interface UserRepository extends JpaRepository<User, Long> {

    

    
}
