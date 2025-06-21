package com.jeanemirele.UBS.handlers;

import com.jeanemirele.UBS.dtos.ErrorResponseDTO;
import com.jeanemirele.UBS.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> resourceNotFound(ResourceNotFoundException e, WebRequest request) {
        String path = request.getDescription(false).replace("uri=", "");
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponseDTO error = new ErrorResponseDTO(status,e.getMessage(), status.getReasonPhrase(), path);
        return new ResponseEntity<>(error, status);
    }
}
