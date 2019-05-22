package com.service;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import com.model.Pizza;
import com.repository.PizzaRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PizzaServiceImpl implements PizzaService, Serializable{

	private static final long serialVersionUID = 1L;

	private PizzaRepository repository;
	
	public PizzaServiceImpl(PizzaRepository pizzaRepository) {
		this.repository = pizzaRepository;
	}

	@Override
	public Mono<Pizza> findById(String id) {
		return repository.findById(id);
	}

	@Override
	public Flux<Pizza> findAll() {
		return repository.findAll();
	}

	@Override
	public Mono<Pizza> save(Pizza pizza) {
		return repository.save(pizza);
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return repository.deleteById(id);
	}

}
