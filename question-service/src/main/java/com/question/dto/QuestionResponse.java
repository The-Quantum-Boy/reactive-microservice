package com.question.dto;

import com.question.model.Question;

public record QuestionResponse(Question data, Error error ) {
}
