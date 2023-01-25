package me.anvarisy.kodegiri.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {
	@Autowired
	private JdbcTemplate springTemplate;
	
	private static final String INSERT_QUERY = 
			"""
				insert into employees (name, salary)
				values(?, ?);		
			""";
	
	private static final String FETCH_QUERY=
			"""
				select id, name, salary from employees;
			""";
	
	private static final String SELECT_QUERY=
			"""
				select id, name, salary from employees where id = ?;
			""";
	
	public void insert(Employee e) {
		springTemplate.update(INSERT_QUERY,
			e.getName(), e.getSalary());
	}
	
	public List<Employee> fetchEmployees() {
		return springTemplate.query(FETCH_QUERY, (rs, rowNum) -> new Employee(
				rs.getLong("id"),
				rs.getString("name"),
				rs.getDouble("salary")
				));
	}
	
	public Employee findEmployeeById(long id) {
		return springTemplate.queryForObject(SELECT_QUERY,
				new BeanPropertyRowMapper<>(Employee.class), id);
	}
}
