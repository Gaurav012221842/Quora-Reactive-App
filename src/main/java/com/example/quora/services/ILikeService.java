package com.example.quora.services;
import com.example.quora.dto.*;
import reactor.core.publisher.*;


public interface ILikeService {
    public Mono<LikeResponseDTO> createLike(LikeRequestDTO likeRequestDTO);
    public  Mono<LikeResponseDTO> countLikesByTargetIdandTargetType(String targetId, String targetType);
    public  Mono<LikeResponseDTO> countDisLikesByTargetIdandTargetType(String targetId, String targetType);
    public  Mono<LikeResponseDTO> toggleLike(String targetId, String targetType, Boolean isLike);


}
