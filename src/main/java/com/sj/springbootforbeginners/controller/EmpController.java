package com.sj.springbootforbeginners.controller;
import java.util.ArrayList;

import com.sj.springbootforbeginners.model.Employee;
import com.sj.springbootforbeginners.service.EmpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmpController {
	
	@Autowired
	EmpServiceImpl empServiceImpl;

	@PostMapping("/")
	public void add() {
		empServiceImpl.addEmployee();
	}

	@GetMapping("/findall")
	public ArrayList<Employee> getAllEmployee() {
		return empServiceImpl.findAllEmployee();
	}

	@GetMapping("/findbyid/{id}")
	public Employee getEmployeeUsingId(@PathVariable long id) {
		return empServiceImpl.findAllEmployeeByID(id);
	}

	@DeleteMapping("/delete")
	public void delete() {
		empServiceImpl.deleteAllData();
	}
}
