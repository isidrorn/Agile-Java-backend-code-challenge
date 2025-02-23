package com.irn.users.infrastructure.adapter.in.web.controller;

import com.irn.users.application.port.in.DeleteUserUseCase;
import com.irn.users.infrastructure.adapter.in.web.controller.model.UserResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeleteUserController {

    private final DeleteUserUseCase deleteUserUseCase;

    @Operation(summary = "Delete an user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User deleted successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResponseDto.class)) }),
            @ApiResponse(responseCode = "404", description = "Username not found",
                    content = @Content)})
    @DeleteMapping("/users/{username}")
    public ResponseEntity<Object> deleteUser(@PathVariable String username) {

        deleteUserUseCase.deleteUser(username);
        return ResponseEntity.ok(username+ " deleted successfully");
    }


}
