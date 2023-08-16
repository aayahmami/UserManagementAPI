package com.usrmngt.usermanagement.exceptions;
/**
 *Class to customise Error
 */
public class UserBirthDateInvalidException extends RuntimeException{
    /**
     * display the message in the case of an exception
     */
    public UserBirthDateInvalidException(){
        super("You must put a valid birthdate");
    }
}
