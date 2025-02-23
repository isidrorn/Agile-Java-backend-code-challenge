package com.irn.users.infrastructure.adapter.in.web.controller;

import com.irn.users.application.port.in.UpdateUserUseCase;
import com.irn.users.infrastructure.adapter.in.web.controller.mapper.UserMapper;
import com.irn.users.infrastructure.adapter.in.web.controller.model.UpdateUserRequestDto;
import com.irn.users.infrastructure.adapter.in.web.controller.model.UserResponseDto;
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

    //TODO OpenApi doc
    @PutMapping("/users/{username}")
    public UserResponseDto updateUser(@RequestBody UpdateUserRequestDto updateUserRequestDto, @PathVariable String username) {
        return userMapper.toDto(
                updateUserUseCase.updateUser(
                        userMapper.toDomain(updateUserRequestDto, username)));
    }


}
