package com.example.quora.dto;

import lombok.Builder;
import lombok.Data;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionResponseDTO {
    private String id;
    private String title;
    private String content;
    private String createdAt;
    private String updatedAt;
}