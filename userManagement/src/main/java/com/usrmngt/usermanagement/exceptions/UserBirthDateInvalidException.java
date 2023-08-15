package com.usrmngt.usermanagement.exceptions;

public class UserBirthDateInvalidException extends RuntimeException{
    public UserBirthDateInvalidException(){
        super("You must put a birthdate");
    }
}
