package com.usrmngt.usermanagement;

import com.usrmngt.usermanagement.model.User;
import com.usrmngt.usermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class UserManagementApplication implements CommandLineRunner {

    @Autowired
    public UserRepository userRepository;

    public static void main(String[] args) {

        SpringApplication.run(UserManagementApplication.class, args);

    }

    @Override
    public void run(String... args){
        List<User> listUser = new ArrayList<>();
        for (int i=0 ; i<4 ; i++){
            listUser.add(new User("Ahmed"+i, LocalDate.of(1998,3,9),"France","003312345678","Male"));
        }
        userRepository.deleteAll();
        userRepository.saveAll(listUser);
    }

}
