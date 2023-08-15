package com.usrmngt.usermanagement.exceptions;

public class UserNameAlreadyExistException extends RuntimeException{
    public UserNameAlreadyExistException(){
        super("UserName already exist");
    }
}
