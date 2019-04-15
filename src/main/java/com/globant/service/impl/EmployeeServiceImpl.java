/**
 * 
 */
package com.globant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globant.dao.EmployeeDao;
import com.globant.model.Employee;
import com.globant.service.EmployeeService;

/**
 * @author jose.luna
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	public List<Employee> getAllEmployees() {
		List<Employee> employees = employeeDao.getAllEmployees();
		return employees;
	}
	
	public Boolean create(Employee employee) {
		return employeeDao.create(employee);
	}
	
	public Employee findById(String id) {
		return employeeDao.findById(id);
	}
	
	public Employee update(Employee employee) {
        return employeeDao.update(employee);
    }
	
	public Boolean delete(String id) {
		return employeeDao.delete(id);
	}
}
