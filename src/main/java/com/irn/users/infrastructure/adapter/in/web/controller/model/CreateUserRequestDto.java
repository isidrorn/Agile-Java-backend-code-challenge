package com.irn.users.infrastructure.adapter.in.web.controller.model;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateUserRequestDto {

    @Schema(name = "username", description = "username", example = "AlexTerrible", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull
    private String username;
    @Schema(name = "name", description = "name", example = "Alexei Stukov", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String name;
    @Schema(name = "email", description = "email", example = "me@mail.org", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String email;
    @Schema(name = "gender", description = "gender", example = "female", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String gender;
    @Schema(name = "picture", description = "URL to profile pictur", example = "https://randomuser.me/api/portraits/thumb/men/56.jpg", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String picture;
    private LocationDto location;

}
