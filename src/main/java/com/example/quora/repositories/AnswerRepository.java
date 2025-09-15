package com.example.quora.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.example.quora.models.*;

@Repository
public interface AnswerRepository extends ReactiveMongoRepository<Answer, String> {

}
