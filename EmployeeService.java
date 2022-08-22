package com.example.demo;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeRepo;



@Service
public class EmployeeService {

	@Autowired
	EmployeeRepo empRepo;
	
	@Transactional
	public Employee saveEmployee(Employee employee) {		
		return empRepo.save(employee);		
	}
	
	@Transactional
	public List<Employee> fetchEmployee() {
		List<Employee> empList=empRepo.findAll();
		return empList;
	}
	
	@Transactional 
	  public Employee getEmployee(int id) { 
	  Optional<Employee> optional=empRepo.findById(id);
	  Employee employee=optional.get();
	  return employee;
	  }
	
	@Transactional
	public void updateEmployee(Employee employee) {
		empRepo.save(employee);		
	}
	
	@Transactional
	public  List<Employee> deleteEmployee(int empId) {
		empRepo.deleteById(empId);
		return empRepo.findAll();
	}
	}

