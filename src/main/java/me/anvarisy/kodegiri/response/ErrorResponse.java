package me.anvarisy.kodegiri.response;

import java.time.LocalDateTime;

public class ErrorResponse {
	private boolean status;
	private LocalDateTime timeStamp;
	private String error;
	private int code;
	

	public ErrorResponse(boolean status, LocalDateTime timeStamp, String error, int code) {
		super();
		this.status = status;
		this.timeStamp = timeStamp;
		this.error = error;
		this.code = code;
	}
	
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	

}
