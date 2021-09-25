package cl.commander.micro_inventory.error;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import cl.commander.micro_inventory.viewmodel.GenericResponse;

@ControllerAdvice
public class ErrorHandler {

	private Logger logger = LoggerFactory.getLogger(ErrorHandler.class);

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<GenericResponse> handleParameterRequiredMissing(
			MissingServletRequestParameterException ex) {
		logger.error("missing_parameters: " + ex.getMessage());
		GenericResponse err = new GenericResponse();
		err.setCode("missing_parameters");
		err.setMessage(ex.getMessage());
		return ResponseEntity.badRequest().header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).body(err);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<GenericResponse> handleBeanValidationError(ConstraintViolationException ex) {
		String msg = "";
		for (ConstraintViolation<?> constraintViolation : ex.getConstraintViolations()) {
			msg += constraintViolation.getPropertyPath().toString() + " - " + constraintViolation.getMessage() + ".\n";
		}
		logger.error("invalid_format_parameters: " + msg);
		GenericResponse err = new GenericResponse();
		err.setCode("invalid_format_parameters");
		err.setMessage(msg);
		return ResponseEntity.badRequest().header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).body(err);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<GenericResponse> handleRequestJsonMalFormed(HttpMessageNotReadableException ex) {
		GenericResponse err = new GenericResponse();
		err.setCode("request_json_mal_formed");
		err.setMessage(ex.getMessage());
		return ResponseEntity.badRequest().body(err);
	}

	
	@ExceptionHandler(MessageException.class)
	public ResponseEntity<GenericResponse> handleMessage(MessageException ex) {
		logger.info("message display: {} {}", ex.getCode(), ex.getMessage());
		GenericResponse err = new GenericResponse();
		err.setCode(ex.getCode());
		err.setMessage(ex.getMessage());
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(err);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<GenericResponse> handleErrorUncontrolled(Exception ex) {
		logger.error("uncontrolled_error", ex);
		GenericResponse err = new GenericResponse();
		err.setCode("uncontrolled_error");
		err.setMessage(
				"To see more information see the logs");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
	}
	
	@ExceptionHandler(java.net.SocketException.class)
	public ResponseEntity<GenericResponse> gateway(java.net.SocketException ex) {
		logger.error("uncontrolled_error", ex);
		GenericResponse err = new GenericResponse();
		err.setCode("error_time_out");
		err.setMessage("problems to response");
		return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(err);
	}
	
	@ExceptionHandler(HttpServerErrorException.class)
	public ResponseEntity<GenericResponse> castError(HttpServerErrorException ex) {
		logger.error("uncontrolled_error", ex);
		GenericResponse err = new GenericResponse();
		err.setCode("ERROR_GENERAL");
		err.setMessage("Error Generic");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
	@ExceptionHandler(InternalServerError.class)
	public ResponseEntity<GenericResponse> castError(InternalServerError ex) {
		logger.error("uncontrolled_error", ex);
		GenericResponse err = new GenericResponse();
		err.setCode("ERROR_GENERAL");
		err.setMessage("Internal error");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<GenericResponse> handleBeanValidationMethod(MethodArgumentNotValidException ex) {
		logger.error("Invalid parameter error: " + ex.getMessage());
		GenericResponse err = new GenericResponse();
		err.setCode("ERROR_IN_FORMAT");
		err.setMessage("Invalid parameter error");
		return ResponseEntity.badRequest().header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).body(err);
	}
	
	@ExceptionHandler(org.springframework.web.client.ResourceAccessException.class)
	public ResponseEntity<GenericResponse> handleTimeout(org.springframework.web.client.ResourceAccessException ex) {
		logger.error("error in timeout: " + ex.getMessage());
		GenericResponse err = new GenericResponse();
		err.setCode("ERROR_TIMEOUT");
		err.setMessage("Error in response time");
		return ResponseEntity.badRequest().header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).body(err);
	}
}
