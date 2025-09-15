package com.example.quora.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.*;
@Builder
@Data  
@NoArgsConstructor
@AllArgsConstructor
public class AnswerResponseDTO {
    
    private String id;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Getters and Setters
}
