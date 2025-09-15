package com.example.quora.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerRequestDTO {
    @NotBlank(message = "Content is mandatory")
    @Size(min = 1, max = 5000, message = "Content cannot exceed 5000 characters")
    private String content;
    @NotBlank(message = "Question ID is mandatory")
    private String questionId;
    
    // Getters and Setters
}
