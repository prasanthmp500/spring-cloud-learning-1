package com.example.web;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
public class GreetingsService {
	
	private final GreetingClient greetingClient;
	
	public GreetingsService (GreetingClient greetingClient) {
		this.greetingClient = greetingClient;
	}
	
	public String getSalutation() {
		return this.greetingClient.getSalutation();
	}
	
	@FeignClient(contextId = "greetingCtxId" , value = "greeting" )
	interface GreetingClient {
		@RequestMapping(value = "/greeting", method = RequestMethod.GET)
		String getSalutation();
	}


}
