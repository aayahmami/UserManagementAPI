package com.usrmngt.usermanagement.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * Class of the main model user with all the input above
 */
@Data
@Entity
@Table(name = "USERS")
public class User {

    public User(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank@Size(min = 6, message = "First Name should have 6 characters")
    @Column(name = "USERNAME")
    private String username;

    @NotNull
    @Past
    @Column(name = "BIRTHDAY")
    private LocalDate birthdate;

    @NotBlank
    @Column(name = "COUNTRY")
    private String country;

    private String phonenumber;

    private String gender;

    /**
     * A simple constructor
     * @param username username
     * @param birthdate birthdate
     * @param country country
     * @param phonenumber phone number  optional
     * @param gender gender optional
     */
    public User(String username,LocalDate birthdate, String country, String phonenumber, String gender) {
        this.username = username;
        this.birthdate = birthdate;
        this.country = country;
        this.phonenumber = phonenumber;
        this.gender = gender;
    }
}
