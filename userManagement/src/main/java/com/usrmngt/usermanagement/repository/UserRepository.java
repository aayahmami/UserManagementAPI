package com.usrmngt.usermanagement.repository;

import com.usrmngt.usermanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * Interface that extends all JpaRepository to get all Jpa method
 * and define new method if needed
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * find user by a given username
     * @param username that we hope to find
     * @return user with all information if the username given founded
     */
    User findByUsername(String username);

    /**
     * find user by a given id
     * @param UserId that we hope find
     * @return user with all information if the id given founded
     */
    User findByUserId(Long UserId);

    /**
     * find all users
     * @return list of all users
     */
    List<User> findAll();

}


//pour bien comprendre
//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/