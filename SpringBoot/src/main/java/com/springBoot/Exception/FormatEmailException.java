package com.springBoot.Exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@Getter
@Setter
public class FormatEmailException extends RuntimeException{
    private String message;

    public FormatEmailException(String message) {
        super();
        this.message = message;
    }
}
