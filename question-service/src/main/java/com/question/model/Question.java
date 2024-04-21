package com.question.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Table("question")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Question {

    @Id
    @Generated
    @Column("questionid")
    private Long questionId;

    @Column("question")
    private String question;

    @Column("quizid")
    private Long quizId;
}
