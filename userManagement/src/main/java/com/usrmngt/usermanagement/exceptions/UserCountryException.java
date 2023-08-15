package com.usrmngt.usermanagement.exceptions;


public class UserCountryException extends RuntimeException {

    public UserCountryException(){
        super("Only french resident are allowed to create an account");
    }

}
