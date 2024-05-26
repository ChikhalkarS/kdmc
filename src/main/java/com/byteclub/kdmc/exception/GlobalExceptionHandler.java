package com.byteclub.kdmc.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.NOT_FOUND.value(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserExistsInSystem.class)
    public ResponseEntity<?> userExistsInSystem(UserExistsInSystem ex,WebRequest request)
    {
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.CONTINUE.value(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<?> invalidCredentials(InvalidCredentials ex,WebRequest request)
    {
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.UNAUTHORIZED.value(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<?> invalidUserSession(InvalidUserSession ex,WebRequest request)
    {
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.NON_AUTHORITATIVE_INFORMATION.value(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NON_AUTHORITATIVE_INFORMATION);
    }

}

@Getter
@Setter
class ErrorDetails {
    private int statusCode;
    private String message;
    private String details;

    public ErrorDetails(int statusCode, String message, String details) {
        super();
        this.statusCode = statusCode;
        this.message = message;
        this.details = details;
    }
}
