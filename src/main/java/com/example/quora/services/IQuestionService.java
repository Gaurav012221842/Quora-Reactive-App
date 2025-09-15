package com.example.quora.services;
import reactor.core.publisher.*;
import com.example.quora.dto.QuestionResponseDTO;
import com.example.quora.dto.QuestionRequestDTO; 
public interface IQuestionService {
    Mono<QuestionResponseDTO> createQuestion(QuestionRequestDTO questionRequestDTO);
    Flux<QuestionResponseDTO> searchQuestions(String searchTerm ,int offset,int pageSize);
    Flux<QuestionResponseDTO> getAllQuestions(String cursor, int size);
    Mono<QuestionResponseDTO> getQuestionById(String id);
    
}

