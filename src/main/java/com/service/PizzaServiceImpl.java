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
	
	public PizzaServiceImpl(PizzaRepository repository) {
		this.repository = repository;
	}

	@Override
	public Mono<Pizza> findById(String id) {
		return this.repository.findById(id);
	}

	@Override
	public Flux<Pizza> findAll() {
		return this.repository.findAll();
	}

	@Override
	public Mono<Pizza> save(Pizza pizza) {
		return this.repository.save(pizza);
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return this.repository.deleteById(id);
	}

}
