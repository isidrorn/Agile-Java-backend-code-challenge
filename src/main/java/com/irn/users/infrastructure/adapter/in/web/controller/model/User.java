package com.irn.users.infrastructure.adapter.in.web.controller.model;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class User {

    @Schema(name = "username", description = "username", example = "someUserName")
    private String username;
    private Name name;
    //TODO validation
    //@Valid
    //@Constraint()
    private String email;
    private String gender;
    private String picture;
    private Location location;

}
