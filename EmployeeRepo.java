package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Employee;

//import com.example.demo.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

}
