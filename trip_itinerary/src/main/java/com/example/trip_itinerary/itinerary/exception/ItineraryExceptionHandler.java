package com.example.trip_itinerary.itinerary.exception;

import com.example.trip_itinerary.trip.controller.TripController;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice(basePackageClasses = TripController.class)
public class ItineraryExceptionHandler {
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<String> handle(EmptyResultDataAccessException e) {
        return ResponseEntity.status((HttpStatus.UNAUTHORIZED))
                .body("해당 아이디를 가진 유저가 없습니다. 아이디 값을 확인해주세요");
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handle(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        StringBuilder errorMessageBuilder = new StringBuilder();

        for (FieldError fieldError : fieldErrors) {
            errorMessageBuilder.append(fieldError.getDefaultMessage()).append("\n");
        }

        String errorMessage = errorMessageBuilder.toString().trim(); // Remove trailing newline

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorMessage);
    }

}