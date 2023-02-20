package com.sj.springbootforbeginners.controller;

import com.sj.springbootforbeginners.model.User;
import com.sj.springbootforbeginners.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/beginners/mongo/crud")
public class MongoController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping(value = "/createUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public String createUser(@RequestBody User groceryItem) {
        userRepository.save(groceryItem);
		return "Successfully added the records";
	}
	@GetMapping(value = "/getByName",produces = MediaType.APPLICATION_JSON_VALUE)
	public User getUserByName(@RequestParam String name) {
		return userRepository.findItemByName(name);
	}
	@GetMapping(value = "/getAllUser",produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<User> getAllUser() {
		return userRepository.findAll();
	}
	@DeleteMapping(value = "/deleteUser",produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteUserById(@RequestParam String id) {
        userRepository.deleteById(id);
		return "Successfully deleted the record for "+ id ;
	}
	@PutMapping(value = "/deleteAllUser",produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteAllUser() {
		userRepository.deleteAll();
		return "Successfully deleted all" ;
	}

}
