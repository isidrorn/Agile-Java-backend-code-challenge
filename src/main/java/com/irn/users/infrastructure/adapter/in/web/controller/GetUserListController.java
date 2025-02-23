package com.irn.users.infrastructure.adapter.in.web.controller;

import com.irn.users.application.port.in.GetUserListUseCase;
import com.irn.users.infrastructure.adapter.in.web.controller.mapper.UserMapper;
import com.irn.users.infrastructure.adapter.in.web.controller.model.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetUserListController {

    private final GetUserListUseCase getUserListUseCase;
    private final UserMapper userMapper;

    //TODO OpenApi doc
    @GetMapping("/users/")
    public Page<UserResponseDto> getUserList(@RequestParam(name = "page", defaultValue = "0") int page,
                                             @RequestParam(name = "size", defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userMapper.toDtoPage(getUserListUseCase.getUserList(pageable));
    }


}
