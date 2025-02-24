package com.irn.users.infrastructure.adapter.in.web.controller.model;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserResponseDto {

    @Schema(name = "username", description = "custom username or alias", example = "someUserName", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull
    private String username;
    @Schema(name = "name", description = "full user's name", example = "someUserName", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String name;
    @Schema(name = "email", description = "e-mail address", example = "example@mail.org", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String email;
    @Schema(name = "gender", description = "user's gender", example = "male/female", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String gender;
    @Schema(name = "picture", description = "URL to user's profile picture", example = "https://img.io/asdf87as", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String picture;
    @Schema(name = "location", description = "location", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocationDto location;

}
