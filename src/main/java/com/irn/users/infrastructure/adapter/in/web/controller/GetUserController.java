package com.irn.users.infrastructure.adapter.in.web.controller;

import com.irn.users.application.port.in.GetUserUseCase;
import com.irn.users.infrastructure.adapter.in.web.controller.mapper.UserMapper;
import com.irn.users.infrastructure.adapter.in.web.controller.model.UserResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetUserController {

    private final GetUserUseCase getUserUseCase;
    private final UserMapper userMapper;

    @Operation(summary = "Get an existing user by its username")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResponseDto.class)) }),
            @ApiResponse(responseCode = "404", description = "Username not found",
                    content = @Content)})
    @GetMapping("/users/{username}")
    public UserResponseDto getUser(@PathVariable String username){
        return userMapper.toDto(getUserUseCase.getUser(username));
    }


}
