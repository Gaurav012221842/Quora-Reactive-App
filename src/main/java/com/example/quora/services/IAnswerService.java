package com.example.quora.services;

import com.example.quora.dto.*;

import reactor.core.publisher.Mono;


public interface  IAnswerService {
    public Mono<AnswerResponseDTO> createAnswer(AnswerRequestDTO answerRequestDTO);
    public Mono<AnswerResponseDTO> getAnswerById(String id);

}
