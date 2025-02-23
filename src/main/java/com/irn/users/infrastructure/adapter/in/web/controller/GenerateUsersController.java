package com.irn.users.infrastructure.adapter.in.web.controller;

import com.irn.users.application.port.in.GenerateUsersUseCase;
import com.irn.users.infrastructure.adapter.in.web.controller.mapper.UserMapper;
import com.irn.users.infrastructure.adapter.in.web.controller.model.UserResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GenerateUsersController {

    private final GenerateUsersUseCase generateUserUseCase;
    private final UserMapper userMapper;

    @Operation(summary = "Generate the number of users requested from randomuser.me/api/")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User created",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResponseDto.class)) }),
            @ApiResponse(responseCode = "400", description = "Please provide an integer from 1 to 1000",
                    content = @Content) })
    @GetMapping("/users/generate/{number}")
    public List<UserResponseDto> generateUsers(@PathVariable @Positive @Max(1000) int number){
        return userMapper.toDtoList(generateUserUseCase.generateUsers(number));
    }


}
