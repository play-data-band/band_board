package com.example.bandboard.config.controller;

import com.example.bandboard.config.exeptions.communitySaveException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomRestControllerAdivice {
    @ExceptionHandler(communitySaveException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String communitySaveExceptionHandler(communitySaveException communitySaveException){
        return communitySaveException.getMessage();
    }
}
