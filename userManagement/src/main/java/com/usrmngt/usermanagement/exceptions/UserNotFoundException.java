package com.usrmngt.usermanagement.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 *Class to customise Error
 * Http Status NOT_FOUND
 * message error : this user is not found in our database
 */
@ResponseStatus(code= HttpStatus.NOT_FOUND,reason = "this user is not found in our database")
public class UserNotFoundException extends RuntimeException{
    /**
     * display the message in the case of an exception
     */
    public UserNotFoundException(){
        super("This user is not found in our database");
    }


}
