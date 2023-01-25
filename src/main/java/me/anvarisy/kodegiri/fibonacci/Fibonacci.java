package me.anvarisy.kodegiri.fibonacci;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Fibonacci {
	@JsonProperty( value = "input", access = JsonProperty.Access.WRITE_ONLY)
	private Integer input;
	
	@JsonProperty( value = "output", access = JsonProperty.Access.READ_ONLY)
	private String output;
	
	public Fibonacci(Integer input, String output) {
		super();
		this.input = input;
		this.output = output;
	}
	
	public Integer getInput() {
		return input;
	}

	public void setInput(Integer input) {
		this.input = input;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	
}
