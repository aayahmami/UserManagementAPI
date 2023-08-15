package com.usrmngt.usermanagement;
import com.usrmngt.usermanagement.constants.Constants;
import com.usrmngt.usermanagement.exceptions.*;
import com.usrmngt.usermanagement.model.User;
import com.usrmngt.usermanagement.service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class UserManagementApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void testRegisterUserOK() {
        User userTest = new User();
        userTest.setUserId(1L);
        userTest.setUsername("Jean-Dupont");
        userTest.setBirthdate(LocalDate.of(1998, 3, 9));
        userTest.setCountry("France");
        userTest.setGender("male");
        userTest.setPhonenumber("+33695765865");

        User registredUser = userService.registerUser(userTest);
        Assert.assertNotNull("User is not null", registredUser.getUserId());
        Assert.assertEquals("Jean-Dupont", registredUser.getUsername());
        Assert.assertEquals(Constants.COUNTRY.toUpperCase() , registredUser.getCountry().toUpperCase());
    }

    @Test
    public void testRegisterUser_CountryNOK()  {
        User userTest = new User();
        userTest.setUserId(1L);
        userTest.setUsername("Jean-Dupont");
        userTest.setBirthdate(LocalDate.of(1998, 3, 9));
        userTest.setCountry("USA");

        Assert.assertThrows(UserCountryException.class,
                () -> {userService.registerUser(userTest);});
    }

    @Test
    public void testRegisterUser_AdultNOK()  {
        User userTest = new User();
        userTest.setUserId(1L);
        userTest.setUsername("Jean-Dupont");
        userTest.setBirthdate(LocalDate.of(2020, 3, 9));
        userTest.setCountry("France");

        Assert.assertThrows(UserAdultException.class,
                () -> {userService.registerUser(userTest);});
    }

    @Test
    public void testRegisterUsernameNull() {
        User userTest = new User();
        userTest.setUserId(1L);
        userTest.setUsername(null);
        userTest.setBirthdate(LocalDate.of(1998, 3, 9));
        userTest.setCountry("France");
        userTest.setGender("male");
        userTest.setPhonenumber("+33695765865");

        Assert.assertThrows(UsernameNullException.class,
                () -> {userService.registerUser(userTest);});
    }

    @Test
    public void testRegisterCountryNull() {
        User userTest = new User();
        userTest.setUserId(1L);
        userTest.setUsername("Dupond");
        userTest.setBirthdate(LocalDate.of(1998, 3, 9));
        userTest.setCountry(null);
        userTest.setGender("male");
        userTest.setPhonenumber("+33695765865");

        Assert.assertThrows(UserCountryNullException.class,
                () -> {userService.registerUser(userTest);});
    }

    @Test
    public void testRegisterBirthdateInvalid() {
        User userTest = new User();
        userTest.setUserId(1L);
        userTest.setUsername("Dupond");
        userTest.setBirthdate(null);
        userTest.setCountry("France");
        userTest.setGender("male");
        userTest.setPhonenumber("+33695765865");

        Assert.assertThrows(UserBirthDateInvalidException.class,
                () -> {userService.registerUser(userTest);});
    }

}

