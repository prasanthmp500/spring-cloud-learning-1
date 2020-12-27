package com.example.greeting;


import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	
	List<String> salutations = Arrays.asList("Dear","Hello", "Hi");
	
	@RequestMapping(method = RequestMethod.GET, path = "/greeting")
	public String getSalutation() {
		
		Random random = new Random();
		
		int index = random.nextInt(salutations.size());
		
		return salutations.get(index);
	}
	

}
