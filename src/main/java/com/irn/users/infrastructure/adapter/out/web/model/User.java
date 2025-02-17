package com.irn.users.infrastructure.adapter.out.web.model;


import lombok.Data;

@Data
public class User {

    private Name name;
    private String email;
    private String gender;
    private String picture;
    private Location location;

}
