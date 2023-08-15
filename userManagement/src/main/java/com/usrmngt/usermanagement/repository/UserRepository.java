package com.usrmngt.usermanagement.repository;

import com.usrmngt.usermanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    User findByUserId(Long UserId);

    List<User> findAll();

}


//pour bien comprendre
//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/