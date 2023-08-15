package com.usrmngt.usermanagement.exceptions;

public class UsernameNullException extends RuntimeException{
    public UsernameNullException(){
        super("You must put a username");
    }
}
