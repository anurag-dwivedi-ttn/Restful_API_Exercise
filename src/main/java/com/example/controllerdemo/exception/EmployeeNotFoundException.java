package com.example.controllerdemo.exception;

//Q6)-Implement Exception Handling for resource not found
public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
