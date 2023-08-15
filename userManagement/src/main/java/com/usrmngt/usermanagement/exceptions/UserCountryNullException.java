package com.usrmngt.usermanagement.exceptions;

public class UserCountryNullException extends RuntimeException{
    public UserCountryNullException(){
        super("You must put a country");
    }
}
