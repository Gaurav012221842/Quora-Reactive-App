package com.example.quora.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import com.example.quora.models.Question;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Repository
public interface QuestionRepository extends ReactiveMongoRepository<Question, String> {
     
}
