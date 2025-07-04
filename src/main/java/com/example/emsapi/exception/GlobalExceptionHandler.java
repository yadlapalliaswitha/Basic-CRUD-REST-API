package com.example.emsapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //Add and exception handler usoing @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<EmployeeResponseError> handleException(EmployeeNotFoundException exception){
        //create Employee Error response
        EmployeeResponseError employeeResponseError = new EmployeeResponseError();
        employeeResponseError.setStatus(HttpStatus.NOT_FOUND.value());
        employeeResponseError.setMessage(exception.getMessage());
        employeeResponseError.setTimeStamp(System.currentTimeMillis());

        //return response entity
        return new ResponseEntity<>(employeeResponseError, HttpStatus.NOT_FOUND);
    }

    //add exception handler to handle any type of exception
    @ExceptionHandler
    public ResponseEntity<EmployeeResponseError> handleException(Exception exe){
        //create Employee Error response
        EmployeeResponseError employeeResponseError = new EmployeeResponseError();

        employeeResponseError.setStatus(HttpStatus.BAD_REQUEST.value());
        employeeResponseError.setMessage(exe.getMessage());
        employeeResponseError.setTimeStamp(System.currentTimeMillis());

        //return response entity
        return new ResponseEntity<>(employeeResponseError, HttpStatus.BAD_REQUEST);
    }
}
