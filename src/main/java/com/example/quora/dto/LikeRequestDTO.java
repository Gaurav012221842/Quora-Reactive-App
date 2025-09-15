package com.example.quora.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LikeRequestDTO {
    @NotBlank(message = "Target ID is required")
    public String targetId;
    @NotBlank(message = "Target Type is required")
    public String targetType;
    @NotNull(message = "Is Like is required")
    public Boolean isLike;

}
