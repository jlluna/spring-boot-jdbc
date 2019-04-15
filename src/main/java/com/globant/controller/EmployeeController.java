/**
 * 
 */
package com.globant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.globant.model.Employee;
import com.globant.service.EmployeeService;

/**
 * @author jose.luna
 *
 */
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	EmployeeService empService;
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Boolean create(@RequestBody Employee employee) {
        return empService.create(employee);
    }
	
	@GetMapping
	public List<Employee> findAll() {
		return empService.getAllEmployees();
	}
	
	@GetMapping("/{id}")
    public Employee findById(@PathVariable String id) {
        return empService.findById(id);
    }
	
	@PutMapping("/{id}")
    public Employee update(@RequestBody Employee employee) {
        return empService.update(employee);
    }
	
	@DeleteMapping("/{id}")
    public Boolean delete(@PathVariable String id) {
        return empService.delete(id);
    }
	
}
