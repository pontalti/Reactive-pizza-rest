package com.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring5.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;

import com.service.PizzaService;

@Controller
public class PizzaController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private PizzaService service;

	public PizzaController() {
		super();
	}

	@RequestMapping("/")
	public String index(final Model model) {
		IReactiveDataDriverContextVariable reactive = new ReactiveDataDriverContextVariable(service.findAll(), 1);
		model.addAttribute("pizzas", reactive);
		return "index";

	}

}
