package com.sj.springbootforbeginners.controller;

import com.sj.springbootforbeginners.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/beginners/api")
public class HelloController {
	
	@RequestMapping(method = RequestMethod.GET, value = "/hello")
	public String sayHello() {
		return "Hello World";
	}

	@GetMapping(value = "/helloUsingPathParameter")
	public String sayHello(@RequestParam String name) {
		return "Hello "+name;
	}

	@GetMapping(value = "/helloUsingPathParameters")
	public String sayHello(@RequestParam String name, @RequestParam String city, @RequestParam String phoneNumber) {
		return "Hello "+name  +" Your are located at: "+city + " your phone number is: "+ phoneNumber;
	}
}
