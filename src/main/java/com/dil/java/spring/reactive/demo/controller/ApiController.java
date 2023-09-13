package com.dil.java.spring.reactive.demo.controller;

import java.time.Duration;
import java.time.LocalTime;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class ApiController {
    
    @GetMapping(path = "/stream-flux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> streamFlux() {
        return Flux.interval(Duration.ofSeconds(1))
        .map(sequence -> "Flux - " + LocalTime.now().toString());
    }
} 
