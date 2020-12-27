package com.example.web;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Service
public class NameService {

	private final HelloClient helloClient;

	public NameService(HelloClient helloClient) {
		this.helloClient = helloClient;
	}

	String getName() {
		return this.helloClient.getName();
	}

	//@FeignClient("name")
	@FeignClient(contextId = "nameCtxId" , value = "name" )
	interface HelloClient {
		@RequestMapping(value = "/name", method = RequestMethod.GET)
		String getName();
	}

}
