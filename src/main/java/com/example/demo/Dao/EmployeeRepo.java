package com.example.demo.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
List<Employee>findByField(String field);
}
