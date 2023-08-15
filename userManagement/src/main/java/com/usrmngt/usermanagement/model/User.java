package com.usrmngt.usermanagement.model;

import jakarta.persistence.*;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;


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

    public User(String username,LocalDate birthdate, String country, String phonenumber, String gender) {
        this.username = username;
        this.birthdate = birthdate;
        this.country = country;
        this.phonenumber = phonenumber;
        this.gender = gender;
    }
}
