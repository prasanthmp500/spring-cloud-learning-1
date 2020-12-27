package com.example.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

	private NameService nameService;
	
	private GreetingsService greetingsService;

	public WebController(NameService nameService, GreetingsService greetingsService) {
		this.nameService = nameService;
		this.greetingsService = greetingsService;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/hi")
	public String sayHi() {
		return  String.format("%s %s ", this.greetingsService.getSalutation(), this.nameService.getName());
	}

}
