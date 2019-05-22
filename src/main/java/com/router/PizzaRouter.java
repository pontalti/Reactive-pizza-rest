package com.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.handler.PizzaHandler;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

import java.io.Serializable;

@Configuration
public class PizzaRouter implements Serializable{

	private static final long serialVersionUID = 1L;

	public PizzaRouter() {
		super();
	}

	@Bean
	public RouterFunction<ServerResponse> route(PizzaHandler handler) {
		return RouterFunctions.route(GET("/fpizzas").and(accept(MediaType.APPLICATION_JSON)), handler::findAll)
				.andRoute(GET("/fpizza/{id}").and(accept(MediaType.APPLICATION_STREAM_JSON)), handler::findById)
				.andRoute(POST("/fpizza").and(accept(MediaType.APPLICATION_JSON)), handler::save)
				.andRoute(DELETE("/fpizza/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::delete);
	}

}
