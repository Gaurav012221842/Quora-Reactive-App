package com.example.quora.controllers;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import com.example.quora.dto.QuestionRequestDTO;
import com.example.quora.dto.QuestionResponseDTO;
import reactor.core.publisher.*;
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
    @GetMapping("/search")
    public Flux<QuestionResponseDTO> searchQuestions(@RequestParam String query,
                                                     @RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "10") int size) {
        return questionService.searchQuestions(query, page, size)
                .doOnComplete(() -> System.out.println("Search completed successfully for term: " + query))
                .doOnError(error -> System.err.println("Error during search: " + error.getMessage()));
    }
    @GetMapping()
    public Flux<QuestionResponseDTO> getAllQuestions(@RequestParam(required = false) String cursor,
                                                      @RequestParam(defaultValue = "10") int size) {
        return questionService.getAllQuestions(cursor, size)
                .doOnComplete(() -> System.out.println("Retrieved all questions successfully"))
                .doOnError(error -> System.err.println("Error retrieving questions: " + error.getMessage()));
    }

}
