package me.anvarisy.kodegiri.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import me.anvarisy.kodegiri.response.Response;


@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository repository;
	
	@GetMapping("/employees")
	public Response<List<Employee>> retreiveAllEmployee(){
			List<Employee> employees = repository.fetchEmployees();
			return new Response<List<Employee>>(true, 200, "Request complete", employees);
	}
	
	@GetMapping("/employee/{id}")
	public Response<Employee> getEmployeeById(@PathVariable long id){
			System.out.println("Start...");
			Employee employee = repository.findEmployeeById(id);
			System.out.println("Result...");
			if(employee.equals(null)) {
				System.out.println("Error");
				throw new IndexOutOfBoundsException();
			}
			return new Response<Employee>(true, 200, "Request complete", employee);
	}
	
}
