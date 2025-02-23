package com.irn.users.infrastructure.adapter.out.web.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RandomUserDto {

    @JsonProperty
    private Name name;
    @JsonProperty
    private String email;
    @JsonProperty
    private String gender;
    @JsonProperty
    private Picture picture;
    @JsonProperty
    private Location location;

}
