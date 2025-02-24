package com.irn.users.infrastructure.adapter.in.web.controller;

import com.irn.users.application.port.in.GetUserTreeUseCase;
import com.irn.users.infrastructure.adapter.in.web.controller.mapper.UserMapper;
import com.irn.users.infrastructure.adapter.in.web.controller.model.UserResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class GetUserTreeController {

    private final GetUserTreeUseCase getUserTreeUseCase;
    private final UserMapper userMapper;

    @Operation(summary = "Returns all existing users grouped by country, state and city")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResponseDto.class)) })
    })
    @GetMapping("/users/tree")
    public Map<String, Map<String, Map<String, List<UserResponseDto>>>> getUserTree(){
        return userMapper.toDtoTree(getUserTreeUseCase.getUserTree());
    }


}
