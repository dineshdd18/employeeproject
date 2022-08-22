package com.example.demo;

import java.util.List;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
//@RequestMapping("/food")
@RestController
public class EmployeeController {

	@Autowired
	EmployeeService empSer;
	
	@GetMapping("/employee")
	public List<Employee> getEmployee() {
		List<Employee> empList = empSer.fetchEmployee();
		return empList;
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int empId)  {
		Employee employee = empSer.getEmployee(empId);
		return ResponseEntity.ok().body(employee);
	}
	
	@PostMapping("/employee")
	public String addEmployee(@RequestBody Employee emp) {
		Employee employee = empSer.saveEmployee(emp);
		return "Hi" + emp.getName() + "your name is added successfully";
	}
	
	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateRegister(@PathVariable("id") int empId,
			@RequestBody Employee employeeDetails) {
		Employee employee= empSer.getEmployee(empId);

        employee.setName(employeeDetails.getName());
        employee.setMailId(employeeDetails.getMailId());
        employee.setState(employeeDetails.getState());
        employee.setMobileno(employeeDetails.getMobileno());
		
		final Employee updatedEmployee = empSer.saveEmployee(employee);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	@DeleteMapping("/employee/{id}")
	public List<Employee> deleteEmployee(@PathVariable("id") int empId) {
	   return empSer.deleteEmployee(empId);
	}
}
