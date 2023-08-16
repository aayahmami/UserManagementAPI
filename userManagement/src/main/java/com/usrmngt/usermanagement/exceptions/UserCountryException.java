package com.usrmngt.usermanagement.exceptions;

/**
 *Class to customise Error
 */
public class UserCountryException extends RuntimeException {
    /**
     * display the message in the case of an exception
     */
    public UserCountryException(){
        super("Only french resident are allowed to create an account");
    }

}
