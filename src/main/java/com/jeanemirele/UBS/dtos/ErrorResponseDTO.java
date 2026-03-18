package com.jeanemirele.UBS.dtos;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ErrorResponseDTO {
    private int status;
    private String message;
    private String error;
    private String path;

    public ErrorResponseDTO(HttpStatus status, String message, String error, String path) {
        this.status = status.value();
        this.message = message;
        this.error = status.getReasonPhrase();
        this.path = path;
    }
}
