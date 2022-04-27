package com.vinimadd.interntask.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.security.InvalidParameterException;

// Take care of exceptions

@ControllerAdvice
public class GlobalExceptionHandler

{
    //     500
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String methodArgumentNotValidException(Exception ex) {
        System.out.println(ex);
        return "An internal error has happened.";
    }
    //     404
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    @ExceptionHandler(InvalidParameterException.class)
    public String resourceNotFoundException(InvalidParameterException ex) {
        System.out.println(ex);
        return "Resource not found.";
    }
}

//            extends ResponseEntityExceptionHandler {
// 500
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorMessage> globalExceptionHandler(Exception ex) {
//        ErrorMessage message = new ErrorMessage(
//                HttpStatus.INTERNAL_SERVER_ERROR.value(),
//                ex.getMessage());
//
//        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
// 404
//    @ExceptionHandler(InvalidParameterException.class)
//    public ResponseEntity<ErrorMessage> resourceNotFoundException(InvalidParameterException ex) {
//        ErrorMessage message = new ErrorMessage(
//                HttpStatus.NOT_FOUND.value(),
//                ex.getMessage());
//
//        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
//    }
//}


