package com.usrmngt.usermanagement.exceptions;
/**
 *Class to customise Error
 */
public class UserNameAlreadyExistException extends RuntimeException{
    /**
     * display the message in the case of an exception
     */
    public UserNameAlreadyExistException(){
        super("UserName already exist");
    }
}
