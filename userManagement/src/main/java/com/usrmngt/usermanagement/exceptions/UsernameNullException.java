package com.usrmngt.usermanagement.exceptions;
/**
 *Class to customise Error
 */
public class UsernameNullException extends RuntimeException{
    /**
     * display the message in the case of an exception
     */
    public UsernameNullException(){
        super("You must put a username");
    }
}
