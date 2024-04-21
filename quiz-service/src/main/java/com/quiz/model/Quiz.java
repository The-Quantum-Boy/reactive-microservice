package com.quiz.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;
import reactor.core.publisher.Flux;

import java.util.List;

@Table("quiz")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Quiz {

    @Id
    @Generated
    private Long id;

    private String title;

    @Transient
    List<Question> questions;
}
