package com.example.quora.services;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.quora.dto.QuestionRequestDTO;

import com.example.quora.dto.QuestionResponseDTO;

import com.example.quora.models.Question;
import com.example.quora.repositories.QuestionRepository;
import com.example.quora.adapter.QuestionAdapter;

import reactor.core.publisher.Mono;
@Service
public class QuestionService  implements IQuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Mono<QuestionResponseDTO> createQuestion(QuestionRequestDTO questionRequestDTO) {
        Question question = Question.builder()
                .title(questionRequestDTO.getTitle())
                .content(questionRequestDTO.getContent())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        return questionRepository.save(question)
        .map(QuestionAdapter::toResponseDTO)
        .doOnSuccess(response-> System.out.println("Question created successfully: " + response.getId()))
        .doOnError(error -> System.err.println("Error creating question: " + error.getMessage()));

    }
    
}
