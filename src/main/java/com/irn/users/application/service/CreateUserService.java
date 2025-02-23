package com.irn.users.application.service;

import com.irn.users.application.port.in.CreateUserUseCase;
import com.irn.users.application.port.out.CreateUserPort;
import com.irn.users.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class CreateUserService implements CreateUserUseCase {

    private final CreateUserPort createUserPort;

    @Override
    public User createUser(User newUser) {
        return createUserPort.createUser(newUser);
    }
}
