package com.sivacodes.interview_analyzer.repository;

import com.sivacodes.interview_analyzer.model.Attempt;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AttemptRepository extends JpaRepository<Attempt, Long> {
    
    List<Attempt> findByUserId(Long userId);

    long countByUserId(Long userId);

    long countByUserIdAndSolvedTrue(Long userId);

    List<Attempt> findTop5ByUserIdOrderByAttemptDateDesc(Long userId);
}
