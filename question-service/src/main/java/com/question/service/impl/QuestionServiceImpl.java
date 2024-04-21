package com.question.service.impl;


import com.question.exception.DataNotFoundException;
import com.question.model.Question;
import com.question.repository.QuestionRepository;
import com.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    public QuestionRepository repository;

    @Override
    public Mono<Question> create(Question question) {
        return repository.save(question);
    }

    @Override
    public Mono<Question> getQuesById(Long questionId) {
        return repository.findById(questionId)
                .switchIfEmpty(Mono.error(new DataNotFoundException("Quiz not found with id: " + questionId)));
    }

    @Override
    public Flux<Question> getAllQuestion() {
        return repository.findAll();
    }

    @Override
    public Flux<Question> getQuestionByQuizId(Long quizId) {
        return repository.findByQuizId(quizId);
    }


}
