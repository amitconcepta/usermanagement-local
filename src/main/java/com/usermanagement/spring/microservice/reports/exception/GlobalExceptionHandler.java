package com.usermanagement.spring.microservice.reports.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException ex) {
        return new ResponseEntity<>(
                ErrorResponse.builder()
                        .ErrorMessage(ex.getMessage())
                        .status(HttpStatus.NOT_FOUND.value())
                        .ErrorCode("Error_0001")
                        .build()
                , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleEmptyInputException(BadRequestException ex) {
        return new ResponseEntity<>(
                ErrorResponse.builder()
                        .ErrorMessage(ex.getMessage())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .ErrorCode("Error_0002")
                        .build()
                , HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<ErrorResponse> handleForbiddenExceptionException(ForbiddenException ex) {
        return new ResponseEntity<>(
                ErrorResponse.builder()
                        .ErrorMessage(ex.getMessage())
                        .status(HttpStatus.FORBIDDEN.value())
                        .ErrorCode("Error_0003")
                        .build()
                , HttpStatus.FORBIDDEN);
    }

}
