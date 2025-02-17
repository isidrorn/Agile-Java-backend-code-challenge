package com.irn.users.infrastructure.adapter.out.persistence.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "users")
public class User {

    private String username;
    private String title;
    private String first;
    private String last;
    private String email;
    private String gender;
    private String picture;
    private String city;
    private String state;
    private String country;

}
