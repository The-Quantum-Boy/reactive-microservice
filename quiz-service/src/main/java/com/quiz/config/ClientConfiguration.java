package com.quiz.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ClientConfiguration {

//    public static final String baseUrl="http://QUESTION-SERVICE";

    @Bean
    @LoadBalanced
    public WebClient.Builder webClient() {

        return WebClient.builder();
    }


}
