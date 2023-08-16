package com.usrmngt.usermanagement.service;

import com.usrmngt.usermanagement.exceptions.*;
import com.usrmngt.usermanagement.repository.UserRepository;
import com.usrmngt.usermanagement.constants.Constants;
import com.usrmngt.usermanagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

/**
 * Class that implements UserRepository to write body of methods
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * display all users
     * @return list of users
     */
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    /**
     * add user in database
     * @param user, user to insert
     * @return user saved in the normal case, and throwing exception if it's not
     */
    public User registerUser(User user){
        if (user == null){
            throw new NullPointerException("User is null");
        }
        if (emptyUsername(user)){
            throw new UsernameNullException();
        }
        if (notValidBirthdate(user)){
            throw new UserBirthDateInvalidException();
        }
        if (emptyCountry(user)){
            throw new UserCountryNullException();
        }
        if (!isFrenchResident(user)){
            throw new UserCountryException();
        }
        if (!isAdultUser(user)){
            throw new UserAdultException();
        }
        if (checkUserName(user)){
            throw new UserNameAlreadyExistException();
        }
        return userRepository.save(user);
    }

    /**
     * display user information by a id given
     * @param userId, id of user to find
     * @return matched user
     */
    public User getUserDetails(Long userId){
        User user = userRepository.findByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException();
        }
        return user;
    }

    /**
     * display user information by an username given
     * @param username, username of user to find
     * @return matched user
     */
    public User getUserDetails(String username){
        User user = userRepository.findByUsername(username);
        if (user == null){
            throw new UserNotFoundException();
        }
        return user;
    }

    /**
     * check if the user is a france resident
     * @param user
     * @return true if it s a france resident
     */
    private boolean isFrenchResident(User user){
        return user.getCountry().equalsIgnoreCase(Constants.COUNTRY);
    }

    /**
     * check the age of a user that will to be registered
     * @param user
     * @return true if age >= 18, user adult
     */
    private boolean isAdultUser(User user){
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(user.getBirthdate(),currentDate).getYears();
        return age >= Constants.AGE_OK;
    }

    /**
     * check if the username given is not empty
     * @param user
     * @return true if the username is null, blank or empty
     */
    private boolean emptyUsername(User user){
        String username = user.getUsername();
        if(username == null || username.isBlank() || username.isEmpty()){
            return true;
        }
        return false;
    }
    /**
     * check if the county given is not empty
     * @param user
     * @return true if the username is null, blank or empty
     */
    private boolean emptyCountry(User user){
        String country = user.getCountry();
        if(country == null || country.isBlank() || country.isEmpty()){
            return true;
        }
        return false;
    }

    /**
     * check if th ebirthdate given is valid
     * @param user
     * @return true if it s not a valid birthdate
     */
    private boolean notValidBirthdate(User user){
        if(user.getBirthdate() == null || user.getBirthdate().isAfter(LocalDate.now())){
            return true;
        }
        return false;
    }

    /**
     * check if the username given is already exist
     * @param user
     * @return true if it s already exist 
     */
    private boolean checkUserName(User user){
        for (User customer : getAllUsers()) {
            if (customer.getUsername().equals(user.getUsername())) {
                return true;
            }
        }
       return false ;
    }



}
