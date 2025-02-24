package com.irn.users.infrastructure.adapter.in.web.controller;

import com.irn.users.application.port.in.UpdateUserUseCase;
import com.irn.users.infrastructure.adapter.in.web.controller.mapper.UserMapper;
import com.irn.users.infrastructure.adapter.in.web.controller.model.UpdateUserRequestDto;
import com.irn.users.infrastructure.adapter.in.web.controller.model.UserResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UpdateUserController {

    private final UpdateUserUseCase updateUserUseCase;
    private final UserMapper userMapper;

    @Operation(summary = "Update an existing user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User updated",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResponseDto.class)) }),
            @ApiResponse(responseCode = "404", description = "Username not found",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Missing/wrong required data",
                    content = @Content) })
    @PutMapping("/users/{username}")
    public UserResponseDto updateUser(@RequestBody UpdateUserRequestDto updateUserRequestDto, @PathVariable String username) {
        return userMapper.toDto(
                updateUserUseCase.updateUser(
                        userMapper.toDomain(updateUserRequestDto, username)));
    }
}
