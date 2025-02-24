package com.irn.users.infrastructure.adapter.in.web.controller;

import com.irn.users.application.port.in.CreateUserUseCase;
import com.irn.users.infrastructure.adapter.in.web.controller.mapper.UserMapper;
import com.irn.users.infrastructure.adapter.in.web.controller.model.CreateUserRequestDto;
import com.irn.users.infrastructure.adapter.in.web.controller.model.UserResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CreateUserController {

    private final CreateUserUseCase createUserUseCase;
    private final UserMapper userMapper;

    @Operation(summary = "Create a new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User created",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResponseDto.class)) }),
            @ApiResponse(responseCode = "400", description = "Username already in use",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Missing required data",
                    content = @Content) })
    @PostMapping("/users/")
    public UserResponseDto getUser(@RequestBody CreateUserRequestDto user){
        return userMapper.toDto(createUserUseCase.createUser(userMapper.toDomain(user)));
    }


}
