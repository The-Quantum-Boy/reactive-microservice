package com.question.service;


import com.question.model.Question;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public interface QuestionService {

    Mono<Question> create(Question question);

    Mono<Question> getQuesById(Long questionId);

    Flux<Question> getAllQuestion();

    Flux<Question> getQuestionByQuizId(Long quizId);
}
