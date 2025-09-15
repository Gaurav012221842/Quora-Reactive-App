package com.example.quora.models;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.*; 
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "questions")
public class Question {
    @Id 
    private String id;
    @NotBlank(message= "Title is Required")
    @Size(min = 2, max = 100, message = "Title must be between 2 and 100 characters")
    private String title;
    @NotBlank(message= "Content is Required")
    @Size(min = 10, max = 1000, message = "Content must be between 10 and 1000 characters")
    private String content;
    private Integer views;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

}
