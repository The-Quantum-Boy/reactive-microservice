package com.quiz.service.impl;

import com.quiz.model.Question;
import com.quiz.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class RouteServiceImpl implements RouteService {



    @Autowired
    private WebClient.Builder webClient;


    @Override
    public Flux<Question> getQuestionOfQuiz(Long quizId) {

        return webClient.build().get()
                .uri("http://question-service/ques/getByQuizId/"+quizId)
                .retrieve()
                .bodyToFlux(Question.class)
                .doOnError(System.out::println);
    }
}
