package me.anvarisy.kodegiri.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import me.anvarisy.kodegiri.response.ErrorResponse;

@ControllerAdvice
public class GeneralException extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
		
		if(ex.getMessage().contains("result size")) {
			ErrorResponse errorDetails = new ErrorResponse(false, LocalDateTime.now(), 
					ex.getMessage(),  404);
			return new ResponseEntity<ErrorResponse>(errorDetails, HttpStatus.NOT_FOUND);
		}else {
			ErrorResponse errorDetails = new ErrorResponse(false, LocalDateTime.now(), 
					ex.getMessage(),  500);
			return new ResponseEntity<ErrorResponse>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	/*
	 * @ExceptionHandler(NotFoundException.class) public final
	 * ResponseEntity<ErrorResponse> handleUserNotFoundException(Exception ex,
	 * WebRequest request) throws Exception { ErrorResponse errorDetails = new
	 * ErrorResponse(false, LocalDateTime.now(), ex.getMessage(), 404);
	 * 
	 * return new ResponseEntity<ErrorResponse>(errorDetails, HttpStatus.NOT_FOUND);
	 * 
	 * }
	 */
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		ErrorResponse errorDetails = new ErrorResponse(false, LocalDateTime.now(), 
				ex.getFieldError().getDefaultMessage(), status.value());
		
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
}
