package com.usrmngt.usermanagement.exceptions;

public class UserAdultException extends RuntimeException {

    public UserAdultException(){
        super("You need to be an adult to create an account");
    }

}