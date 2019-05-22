package com.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.model.Pizza;
import com.service.PizzaService;

import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import java.io.Serializable;

@Component
public class PizzaHandler implements Serializable{

	private static final long serialVersionUID = 1L;

	private final PizzaService service;

	public PizzaHandler(PizzaService service) {
		this.service = service;
	}

	public Mono<ServerResponse> findById(ServerRequest request) {
		String id = request.pathVariable("id");
		return ok().contentType(MediaType.APPLICATION_JSON).body(service.findById(id), Pizza.class);
	}

	public Mono<ServerResponse> findAll(ServerRequest request) {
		return ok().contentType(MediaType.APPLICATION_JSON).body(service.findAll(), Pizza.class);
	}

	public Mono<ServerResponse> save(ServerRequest request) {
		final Mono<Pizza> pizza = request.bodyToMono(Pizza.class);
		return ok().contentType(MediaType.APPLICATION_JSON)
				.body(fromPublisher(pizza.flatMap(service::save), Pizza.class));
	}

	public Mono<ServerResponse> delete(ServerRequest request) {
		String id = request.pathVariable("id");
		return ok().contentType(MediaType.APPLICATION_JSON).body(service.deleteById(id), Void.class);
	}

}
