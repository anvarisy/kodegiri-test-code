package me.anvarisy.kodegiri.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Transient;

public class Response<T> {
	@JsonProperty( value = "status", access = JsonProperty.Access.READ_ONLY)
	@Transient
	private boolean status;
	
	@JsonProperty( value = "code", access = JsonProperty.Access.READ_ONLY)
	@Transient
	private int code;
	
	@JsonProperty( value = "message", access = JsonProperty.Access.READ_ONLY)
	@Transient
	private String message;
	
	@JsonProperty( value = "data", access = JsonProperty.Access.READ_ONLY)
	@Transient
	private T data;

	public Response(boolean status, int code, String message, T data) {
		super();
		this.status = status;
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
}
