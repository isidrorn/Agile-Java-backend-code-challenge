package com.irn.users.domain.model;


import lombok.Data;

@Data
public class User {

    private String username;
    private Name name;
    private String email;
    private String gender;
    private String picture;
    private Location location;

}
