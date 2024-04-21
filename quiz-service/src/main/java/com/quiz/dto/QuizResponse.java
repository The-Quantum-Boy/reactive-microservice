package com.quiz.dto;

import com.quiz.model.Quiz;

public record QuizResponse(Quiz quiz,Error error ) {
}
