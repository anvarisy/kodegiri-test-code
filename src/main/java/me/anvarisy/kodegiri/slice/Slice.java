package me.anvarisy.kodegiri.slice;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Slice {
	
	@JsonProperty( value = "input", access = JsonProperty.Access.WRITE_ONLY)
	private String input;
	
	@JsonProperty( value = "output", access = JsonProperty.Access.READ_ONLY)
	private Integer result;
	
	public Slice(String input, Integer result) {
		super();
		this.input = input;
		this.result = result;
	}

	public String getInput() {
		return input;
	}
	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public void setInput(String input) {
		this.input = input;
	}


	@Override
	public String toString() {
		return "Slice [result=" + result + "]";
	}
	

}
