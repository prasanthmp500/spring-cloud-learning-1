package com.example.name;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {
	
	
	List<String> names = Arrays.asList("User","Subscriber", "Customer");
	
	@RequestMapping(method = RequestMethod.GET, path = "/name")
	public String getName() {
		
		Random random = new Random();
		
		int index = random.nextInt(names.size());
		
		return names.get(index);
	}
	

}
