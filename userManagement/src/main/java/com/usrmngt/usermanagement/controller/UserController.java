package com.usrmngt.usermanagement.controller;

import com.usrmngt.usermanagement.service.UserService;
import com.usrmngt.usermanagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

/**
 * Class UserController to define and expose different endpoints
 */

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * user to insert User
     * @param user, insert inside the database
     * @return ResponseEntity or throw error
     */
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody @Valid User user) {
        try{
            User registredUser = userService.registerUser(user);
            return new ResponseEntity<User>(registredUser, HttpStatus.CREATED);
        }catch (Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * used to get an user by a given id
     * @param id
     * @return User
     */
    @GetMapping( "/{id}")
    public ResponseEntity<User> getUserDetails(@PathVariable Long id) {
        try{
            User detailUser = userService.getUserDetails(id);
            return new ResponseEntity<User>(detailUser, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    /**
     * used to get an user by a given username
     * @param username
     * @return User
     */
    @RequestMapping( params = "username")
    public ResponseEntity<User>  getUserDetails(@RequestParam String username){
        try {
            User detailUser = userService.getUserDetails(username);
            return new ResponseEntity<User>(detailUser, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping()
    public ResponseEntity<List<User>> getAll(){
        List<User> userList = userService.getAllUsers();
        return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
    }
}


// note a voir pour httprequest response
//https://devwithus.com/exception-handling-spring-boot-rest-api/
//https://springframework.guru/exception-handling-in-spring-boot-rest-api/
