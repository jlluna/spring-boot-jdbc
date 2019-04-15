/**
 * 
 */
package com.globant.service;

import java.util.List;

import com.globant.model.Employee;

/**
 * @author jose.luna
 *
 */
public interface EmployeeService {

	List<Employee> getAllEmployees();
	
	Boolean create(Employee employee);
	
	Employee findById(String id);
	
	Employee update(Employee employee);
	
	Boolean delete(String id);
}
