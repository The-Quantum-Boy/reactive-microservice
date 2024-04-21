package com.question.repository;

import com.question.model.Question;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface QuestionRepository extends ReactiveCrudRepository<Question ,Long> {

    Flux<Question> findByQuizId(Long quizId);
}
