package me.anvarisy.kodegiri.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EmployeeRunner implements CommandLineRunner{
	
	@Autowired
	private EmployeeRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		if(repository.fetchEmployees().size()<=0) {
			repository.insert(new Employee("Anvarisy", 11000000d));
			repository.insert(new Employee("Widi", 9000000d));
		}
		
	}

}
