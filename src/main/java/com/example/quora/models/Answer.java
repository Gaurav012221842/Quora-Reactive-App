package com.example.quora.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;


@Data
@Builder    
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "answers")
public class Answer {
    @Id
    private String id;
    @NotBlank(message = "Content must not be blank")
    @Size(min =10 ,max = 500, message = "Content must not exceed 500 characters")
    private String content;
    @Indexed
    private String questionId;
    
    @CreatedDate
    @Indexed
    private String createdAt;
    @LastModifiedDate
    private String updatedAt;

    
}
