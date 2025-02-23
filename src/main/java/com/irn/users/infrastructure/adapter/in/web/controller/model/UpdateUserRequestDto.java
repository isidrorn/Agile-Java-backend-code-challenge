package com.irn.users.infrastructure.adapter.in.web.controller.model;


import lombok.Data;

@Data
public class UpdateUserRequestDto {


    private String name;
    //TODO validation
    //@Valid
    //@Constraint()
    private String email;
    private String gender;
    private String picture;
    private LocationDto location;

}
