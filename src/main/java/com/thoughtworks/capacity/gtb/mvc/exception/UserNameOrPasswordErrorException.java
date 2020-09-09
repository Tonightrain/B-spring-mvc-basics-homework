package com.thoughtworks.capacity.gtb.mvc.exception;

public class UserNameOrPasswordErrorException extends RuntimeException{
    public UserNameOrPasswordErrorException(String message){
        super(message);
    }
}
