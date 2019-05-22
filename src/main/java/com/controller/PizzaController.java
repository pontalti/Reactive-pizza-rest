package com.controller;

import org.springframework.web.bind.annotation.RestController;

import com.model.Pizza;
import com.service.PizzaService;

import java.io.Serializable;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PizzaController implements Serializable{

	private static final long serialVersionUID = 1L;

	private PizzaService service;

	public PizzaController(PizzaService service) {
		this.service = service;
	}

	@GetMapping(value = "/Pizza/{id}")
	public Mono<Pizza> getPizzaById(@PathVariable String id) {
		return service.findById(id);
	}

	@GetMapping(value = "/Pizzas")
	public Flux<Pizza> getAllPizzas() {
		return service.findAll();
	}

	@PostMapping(value = "/Pizza")
	public Mono<Pizza> createPizza(@RequestBody Pizza Pizza) {
		return service.save(Pizza);
	}

}
