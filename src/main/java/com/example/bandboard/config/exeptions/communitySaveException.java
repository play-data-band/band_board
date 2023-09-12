package com.example.bandboard.config.exeptions;

public class communitySaveException extends Exception{
    public communitySaveException(Exception e){
        super(e.getMessage());
    }
}
