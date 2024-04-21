package com.quiz.controller;

import com.quiz.dto.Error;
import com.quiz.dto.QuizResponse;
import com.quiz.model.Quiz;
import com.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    public QuizService quizService;


    @PostMapping("/create")
    public Mono<Quiz> createQuiz(@RequestBody Quiz quiz){
        return quizService.add(quiz);
    }

    @GetMapping("/getAll")
    public Flux<Quiz> getAllQuiz(){

        return quizService.get();
    }


    @GetMapping("/get/{id}")
    public Mono<QuizResponse> getQuizById(@PathVariable Long id){
        return quizService.get(id)
                .map(quiz -> new QuizResponse(quiz, null))
                .onErrorResume(error -> Mono.just(new QuizResponse(null, new Error(error.getMessage()))));
    }

}

