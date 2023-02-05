package com.sj.springbootforbeginners.controller;

import com.sj.springbootforbeginners.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;

@RestController
@RequestMapping("/beginners/crud")
public class CRUDController {

	private HashMap<String, User> collection = new HashMap<>();

	@PostMapping(value = "/createUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public String createUser(@RequestBody User user) {
		collection.put(user.getName(), user);
		return "Successfully added the records";
	}
	@GetMapping(value = "/getUser",produces = MediaType.APPLICATION_JSON_VALUE)
	public User getUserByName(@RequestParam String name) {
		return collection.get(name);
	}
	@GetMapping(value = "/getAllUsers",produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<User> getUserByName() {
		return collection.values();
	}
	@DeleteMapping(value = "/deleteUser",produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteUserByName(@RequestParam String name) {
		collection.remove(name);
		return "Successfully deleted the record for "+ name ;
	}
	@PutMapping(value = "/updateUser",produces = MediaType.APPLICATION_JSON_VALUE)
	public String updateUserByName(@RequestParam String name, @RequestBody User user) {
		collection.put(name,user);
		return "Successfully updates the record for "+ name ;
	}

}
