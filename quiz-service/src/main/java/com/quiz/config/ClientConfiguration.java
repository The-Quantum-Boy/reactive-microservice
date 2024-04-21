package com.quiz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ClientConfiguration {


    public static final String baseUrl="http://localhost:8082";

    @Bean
    public WebClient webClient() {

        return WebClient.builder()
                .baseUrl(baseUrl)
                .build();
    }


}
