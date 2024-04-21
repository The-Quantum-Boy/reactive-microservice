package com.quiz.repo;

import com.quiz.model.Quiz;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends ReactiveCrudRepository<Quiz,Long> {
}
