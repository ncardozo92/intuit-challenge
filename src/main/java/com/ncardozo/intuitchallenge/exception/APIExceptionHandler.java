package com.ncardozo.intuitchallenge.exception;

import com.ncardozo.intuitchallenge.entity.ErrorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class APIExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorDto> handleException(ApiException e){
        ErrorDto dto = new ErrorDto(e.getMessage());

        return ResponseEntity.status(e.getStatusCode()).body(dto);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDto> handleValidationErrors(MethodArgumentNotValidException e){
        ErrorDto dto = new ErrorDto("Datos inválidos");

        e.getBindingResult().getFieldErrors()
                .stream().forEach(fe -> dto.addDetalle(fe.getDefaultMessage()));

        return ResponseEntity.status(400).body(dto);
    }
}
