package com.example.quora.dto;

import java.time.LocalDateTime;
import lombok.*;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class LikeResponseDTO {
    public String id;
    public String targetId;
    public String targetType;
    public Boolean isLike;
    public LocalDateTime createdAt;

}
