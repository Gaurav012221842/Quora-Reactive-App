package com.example.quora.services;
import reactor.core.publisher.*;
import com.example.quora.dto.QuestionResponseDTO;
import com.example.quora.dto.QuestionRequestDTO; 
public interface IQuestionService {
    Mono<QuestionResponseDTO> createQuestion(QuestionRequestDTO questionRequestDTO);
}

