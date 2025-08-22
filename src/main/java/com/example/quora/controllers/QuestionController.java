package com.example.quora.controllers;
import com.example.quora.models.Question;
import com.example.quora.repositories.QuestionRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.example.quora.dto.QuestionRequestDTO;
import com.example.quora.dto.QuestionResponseDTO;
import com.example.quora.services.IQuestionService;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {
    private final IQuestionService questionService;

    public QuestionController(IQuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping()
    public Mono<QuestionResponseDTO> createQuestion(@RequestBody QuestionRequestDTO questionRequestDTO) {
        return questionService.createQuestion(questionRequestDTO)
        .doOnSuccess(response -> System.out.println("Question created successfully: " + response))
        .doOnError(error -> System.err.println("Error creating question: " + error));
    }
    

}
