package com.example.quora.repositories;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.time.LocalDateTime;

import org.springframework.data.domain.Pageable;
import com.example.quora.models.Question;
import reactor.core.publisher.*;
@Repository
public interface QuestionRepository extends ReactiveMongoRepository<Question, String> {
    @Query("{ '$or': [ { 'title': { '$regex': ?0, '$options': 'i' } }, { 'content': { '$regex': ?0, '$options': 'i' } } ] }")
    Flux<Question> findByTitleOrContentContainingIgnoreCase(String searchTerm, Pageable pageable);
    Flux<Question> findByCreatedAtGreaterThanOrderByCreatedAtAsc(LocalDateTime cursor, Pageable pageable);
    Flux<Question> findTop10ByOrderByCreatedAtAsc();
}
