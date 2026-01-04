package com.virendra.restful_webservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundExecption extends RuntimeException {
    public UserNotFoundExecption(String message) {
        super(message);
    }
}
