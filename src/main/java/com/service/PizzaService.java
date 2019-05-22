package com.service;

import com.model.Pizza;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PizzaService {

	public Mono<Pizza> findById(String id);
	public Flux<Pizza> findAll();
	public Mono<Pizza> save(Pizza pizza);
	public Mono<Void> deleteById(String id);
	
}
