package com.quiz.service;

import com.quiz.model.Question;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public interface RouteService {

    Flux<Question> getQuestionOfQuiz(Long quizId);
}
