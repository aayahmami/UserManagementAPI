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


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

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

    public User getUserDetails(Long userId){
        User user = userRepository.findByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException();
        }
        return user;
    }

    public User getUserDetails(String username){
        User user = userRepository.findByUsername(username);
        if (user == null){
            throw new UserNotFoundException();
        }
        return user;
    }

    private boolean isFrenchResident(User user){
        return user.getCountry().equalsIgnoreCase(Constants.COUNTRY);
    }

    private boolean isAdultUser(User user){
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(user.getBirthdate(),currentDate).getYears();
        return age >= Constants.AGE_OK;
    }
    private boolean emptyUsername(User user){
        String username = user.getUsername();
        if(username == null || username.isBlank() || username.isEmpty()){
            return true;
        }
        return false;
    }

    private boolean emptyCountry(User user){
        String country = user.getCountry();
        if(country == null || country.isBlank() || country.isEmpty()){
            return true;
        }
        return false;
    }

    private boolean notValidBirthdate(User user){
        if(user.getBirthdate() == null || user.getBirthdate().isAfter(LocalDate.now())){
            return true;
        }
        return false;
    }



    private boolean checkUserName(User user){
        for (User customer : getAllUsers()) {
            if (customer.getUsername().equals(user.getUsername())) {
                return true;
            }
        }
       return false ;
    }



}
