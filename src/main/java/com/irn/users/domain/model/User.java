package com.irn.users.domain.model;


import lombok.Data;

@Data
public class User {

    //username  is concatenation of title + first + last when externally generated
    private String username;
    private String name;
    private String email;
    private String gender;
    private String picture;
    private String city;
    private String state;
    private String country;


}
