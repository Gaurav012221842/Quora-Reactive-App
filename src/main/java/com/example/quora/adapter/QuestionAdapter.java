package com.example.quora.adapter;
import com.example.quora.dto.QuestionResponseDTO;
import com.example.quora.models.Question;

public class QuestionAdapter {
    public static QuestionResponseDTO toResponseDTO(Question question) {
        return QuestionResponseDTO.builder()
                .id(question.getId())
                .title(question.getTitle())
                .content(question.getContent())
                .createdAt(question.getCreatedAt().toString())
                .updatedAt(question.getUpdatedAt().toString())
                .build();
    }
    
}
