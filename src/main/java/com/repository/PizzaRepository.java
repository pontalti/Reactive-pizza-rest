package com.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.model.Pizza;

public interface PizzaRepository extends ReactiveMongoRepository<Pizza, String>{

}
