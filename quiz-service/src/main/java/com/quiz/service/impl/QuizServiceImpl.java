package com.quiz.service.impl;

import com.quiz.exception.DataNotFoundException;
import com.quiz.model.Quiz;
import com.quiz.repo.QuizRepository;
import com.quiz.service.QuizService;
import com.quiz.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {


    @Autowired
    public QuizRepository quizRepository;

    @Autowired
    public RouteService routeService;

    @Override
    public Mono<Quiz> add(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Flux<Quiz> get() {
        Flux<Quiz> quizes = quizRepository.findAll();
        return quizes.flatMap(q -> {
            return routeService.getQuestionOfQuiz(q.getId())
                    .collectList()
                    .map(questions -> {
                        q.setQuestions(questions);
                        return q;
                    });
        });
    }

    @Override
    public Mono<Quiz> get(Long id) {
        return quizRepository.findById(id)
                .switchIfEmpty(Mono.error(new DataNotFoundException("Quiz not found with id: " + id)));
    }


}
