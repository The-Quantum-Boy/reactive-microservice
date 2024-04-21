package com.quiz.service;

import com.quiz.model.Quiz;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public interface QuizService {

    Mono<Quiz> add(Quiz quiz);

    Flux<Quiz> get();

    Mono<Quiz> get(Long id);

}
