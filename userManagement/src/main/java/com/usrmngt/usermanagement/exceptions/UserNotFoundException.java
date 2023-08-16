package com.usrmngt.usermanagement.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND,reason = "this user is not found in our database")
public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(){
        super("This user is not found in our database");
    }


}
