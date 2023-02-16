package com.sj.springbootforbeginners.service;
import com.sj.springbootforbeginners.model.Employee;

import java.util.ArrayList;
public interface EmpService {
	ArrayList<Employee> findAllEmployee();
	Employee findAllEmployeeByID(long id);
	void addEmployee();
	void deleteAllData();
}
