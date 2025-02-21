package com.irn.users.infrastructure.adapter.in.web.controller.model;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserRequestDto {

    @Schema(name = "username", description = "username", example = "someUserName", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull
    private String username;
    private String name;
    //TODO validation
    //@Valid
    //@Constraint()
    private String email;
    private String gender;
    private String picture;
    private LocationRequestDto location;

}
