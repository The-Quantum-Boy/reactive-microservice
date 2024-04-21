package com.question.controller;

import com.question.dto.Error;
import com.question.dto.QuestionResponse;
import com.question.model.Question;
import com.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/ques")
public class QuestionController {

    @Autowired
    public QuestionService questionService;

    @PostMapping("/create")
    public Mono<Question> create(@RequestBody Question question){
        return questionService.create(question);
    }


    @GetMapping("/getAll")
    public Flux<Question> getAll(){
        return questionService.getAllQuestion();
    }


    @GetMapping("/get/{questionId}")
    public Mono<QuestionResponse> getById(@PathVariable Long questionId){
        return questionService.getQuesById(questionId)
                .map(s->new QuestionResponse(s,null))
                .onErrorResume(error->Mono.just(new QuestionResponse(null,new Error("Question not found with this id -> "+questionId))));
    }


    @GetMapping("/getByQuizId/{quizId}")
    public Flux<Question> getQuestionByQuizId(@PathVariable Long quizId){
        return questionService.getQuestionByQuizId(quizId);
    }


}
