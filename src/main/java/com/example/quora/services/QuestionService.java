package com.example.quora.services;
import java.time.LocalDateTime;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.quora.dto.QuestionRequestDTO;

import com.example.quora.dto.QuestionResponseDTO;

import com.example.quora.models.Question;
import com.example.quora.repositories.QuestionRepository;
import com.example.quora.utils.CursorUtils;
import com.example.quora.adapter.QuestionAdapter;

import reactor.core.publisher.*;
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
    @Override
    public Flux<QuestionResponseDTO> searchQuestions(String searchTerm, int offset, int pageSize) {
        return questionRepository.findByTitleOrContentContainingIgnoreCase(searchTerm,PageRequest.of(offset, pageSize))
                .map(QuestionAdapter::toResponseDTO)
                .doOnError(error -> System.err.println("Error during search: " + error.getMessage()))
                .doOnComplete(() -> System.out.println("Search completed successfully for term: " + searchTerm));
    }
    @Override
    public Flux<QuestionResponseDTO> getAllQuestions(String cursor, int size) {
        Pageable pageable = PageRequest.of(0, size);
        if(!CursorUtils.isValidCursor(cursor)){
            return questionRepository.findTop10ByOrderByCreatedAtAsc()
            .take(size)
            .map(QuestionAdapter::toResponseDTO)
            .doOnError(error -> System.err.println("Error retrieving questions: " + error.getMessage()))
            .doOnComplete(() -> System.out.println("Retrieved all questions successfully."));

        }
        else{
            LocalDateTime cursorTime = CursorUtils.parseCursor(cursor);
            return questionRepository.findByCreatedAtGreaterThanOrderByCreatedAtAsc(cursorTime,pageable)
            .map(QuestionAdapter::toResponseDTO)
            .doOnError(error -> System.err.println("Error retrieving questions: " + error.getMessage()))
            .doOnComplete(() -> System.out.println("Retrieved all questions successfully."));
        }

    }

}
