package com.usrmngt.usermanagement.exceptions;
/**
 *Class to customise Error
 */
public class UserAdultException extends RuntimeException {
    /**
     * display the message in the case of an exception
     */
    public UserAdultException(){
        super("You need to be an adult to create an account");
    }

}