package com.quiz.exception;


import com.quiz.entities.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ErrorDetails> IdNotFoundException(IdNotFoundException e)
    {

        ErrorDetails errorresponce = new ErrorDetails(e.getMessage() , LocalDateTime.now());

        return new ResponseEntity<>(errorresponce, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> internalServerError(Exception ex)
    {
    ErrorDetails errordetails = new ErrorDetails(ex.getMessage(),LocalDateTime.now());
    return new ResponseEntity<>(errordetails,HttpStatus.INTERNAL_SERVER_ERROR);
    }



    @ExceptionHandler(TimeOutErrorException.class)
    public ResponseEntity<?> TimeOutErrorExcepton(TimeOutErrorException ex)
    {
        ErrorDetails errordetails = new ErrorDetails(ex.getMessage(),LocalDateTime.now());
        return  new ResponseEntity<>(errordetails,HttpStatus.GATEWAY_TIMEOUT);

    }
}
