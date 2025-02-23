package com.irn.users.infrastructure.adapter.in.web.controller;

import com.irn.users.application.port.in.GetUserTreeUseCase;
import com.irn.users.infrastructure.adapter.in.web.controller.mapper.UserMapper;
import com.irn.users.infrastructure.adapter.in.web.controller.model.UserResponseDto;
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

    //TODO OpenApi doc
    @GetMapping("/users/tree")
    public Map<String, Map<String, Map<String, List<UserResponseDto>>>> getUserTree(){
        return userMapper.toDtoTree(getUserTreeUseCase.getUserTree());
    }


}
