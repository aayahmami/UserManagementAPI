package com.usrmngt.usermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestUserManagementApplication {

    public static void main(String[] args) {
        SpringApplication.from(UserManagementApplication::main).with(TestUserManagementApplication.class).run(args);
    }

}
