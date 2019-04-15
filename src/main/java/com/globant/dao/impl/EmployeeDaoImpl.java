/**
 * 
 */
package com.globant.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.globant.dao.EmployeeDao;
import com.globant.model.Employee;

/**
 * @author jose.luna
 *
 */
@Repository
public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDao {
	
	@Autowired
	DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Override
	public List<Employee> getAllEmployees() {
		String sql = "SELECT * FROM employee";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

		List<Employee> result = new ArrayList<Employee>();
		for (Map<String, Object> row : rows) {
			Employee emp = new Employee();
			emp.setEmpId((String) row.get("empId"));
			emp.setEmpName((String) row.get("empName"));
			result.add(emp);
		}

		return result;
	}
	
	/* (non-Javadoc)
	 * @see com.globant.dao.EmployeeDao#create(com.globant.model.Employee)
	 */
	public Boolean create(Employee employee) {
		// the mysql insert statement
		String sql = " INSERT INTO employee (empId, empName) values (?, ?)";

		// Execute insert operation
		return getJdbcTemplate().update(sql, employee.getEmpId(), employee.getEmpName()) == 1 ? true : false;
	}
	
	/* (non-Javadoc)
	 * @see com.globant.dao.EmployeeDao#findById(java.lang.String)
	 */
	public Employee findById(String id) {
		String sql = " SELECT empId, empName FROM  employee WHERE empId = '" + id + "'";
		logger.info(sql);
		
		Employee employee = getJdbcTemplate().queryForObject(sql, Employee.class);
		
		return employee;
	}
	
	/* (non-Javadoc)
	 * @see com.globant.dao.EmployeeDao#update(com.globant.model.Employee)
	 */
	public Employee update(@RequestBody Employee employee) {
		// the mysql insert statement
		String sql = " UPDATE employee SET empName = '" + employee.getEmpName() + "' where empId = "
				+ employee.getEmpId() + "'";

		// Execute insert operation
		getJdbcTemplate().update(sql);
		
		sql = " SELECT empId, empName FROM  employee WHERE empId = '" + employee.getEmpId() + "'";		
		Employee upEmployee = getJdbcTemplate().queryForObject(sql, Employee.class);
		
		return upEmployee;
    }

	/* (non-Javadoc)
	 * @see com.globant.dao.EmployeeDao#delete(java.lang.String)
	 */
	public Boolean delete(String id) {
		String sql = " DELETE FROM employee WHERE empId = '" + id + "'";
		
		return getJdbcTemplate().update(sql) == 1 ? true : false;
		
	}
}
