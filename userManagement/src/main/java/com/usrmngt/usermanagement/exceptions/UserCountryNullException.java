package com.usrmngt.usermanagement.exceptions;
/**
 *Class to customise Error
 */
public class UserCountryNullException extends RuntimeException{
    /**
     * display the message in the case of an exception
     */
    public UserCountryNullException(){
        super("You must put a country");
    }
}
