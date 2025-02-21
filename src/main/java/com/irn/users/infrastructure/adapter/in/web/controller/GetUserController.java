package com.irn.users.infrastructure.adapter.in.web.controller;

import com.irn.users.application.port.in.GetUserUseCase;
import com.irn.users.infrastructure.adapter.in.web.controller.mapper.UserMapper;
import com.irn.users.infrastructure.adapter.in.web.controller.model.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetUserController {

    private final GetUserUseCase getUserUseCase;
    private final UserMapper userMapper;

    @GetMapping("/users/{username}")
    public UserResponseDto getUser(@PathVariable String username){
        return userMapper.toDto(getUserUseCase.getUser(username));
    }


}
