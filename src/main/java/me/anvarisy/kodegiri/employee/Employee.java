package me.anvarisy.kodegiri.employee;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity(name = "employees")
@JsonPropertyOrder({ "id", "name", "salary" })
public class Employee {
	@JsonProperty( value = "id", access = JsonProperty.Access.READ_ONLY)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
    private Long id;
	
	@Size(min=4, message = "Name should have atleast 4 characters")
	private String name;
	
	private Double salary;
	
	
	
	public Employee() {
		super();
	}

	public Employee(Long id, @Size(min = 4, message = "Name should have atleast 4 characters") String name,
			Double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public Employee(@Size(min = 4, message = "Name should have atleast 4 characters") String name,
			Double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	
	
}
