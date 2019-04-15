/**
 * 
 */
package com.globant.dao;

import java.util.List;

import com.globant.model.Employee;

/**
 * @author jose.luna
 *
 */
public interface EmployeeDao {
	
	List<Employee> getAllEmployees();
	
	Boolean create(Employee employee);
	
	Employee findById(String id);

	Employee update(Employee employee);
	
	Boolean delete(String id);
}
