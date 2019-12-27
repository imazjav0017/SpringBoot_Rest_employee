package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dao.EmployeeRepo;
import com.example.demo.models.Employee;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ServiceController {
	@Autowired
	EmployeeRepo repo;
	@GetMapping(path="/employees")
	public List<Employee> getEmployees()
	{
		return repo.findAll();
	}
	@GetMapping(path="/employees/{empId}")
	public Employee getEmployee(@PathVariable("empId")int empId)
	{
		return repo.findById(empId).orElse(new Employee());
	}
	@PostMapping(path="/employees",consumes= {"application/json"})
	public Employee addEmployee(@RequestBody Employee emp)
	{
		repo.save(emp);
		return emp;
	}
	@GetMapping(path="/employee/{field}")
	public List<Employee> getEmployeeByField(@PathVariable("field") String field)
	{
		return repo.findByField(field);
	}
}
