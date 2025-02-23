package com.irn.users.infrastructure.adapter.in.web.controller.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class LocationDto {

    @Schema(name = "city", description = "city", example = "Boston", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String city;
    @Schema(name = "state", description = "state", example = "Massachusetts", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String state;
    @Schema(name = "country", description = "country", example = "United States", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String country;
}
