package com.irn.users.application.service;

import com.irn.users.application.port.in.GetUserUseCase;
import com.irn.users.application.port.out.GetUserPort;
import com.irn.users.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class GetUserService implements GetUserUseCase {

    private final GetUserPort getUserPort;

    @Override
    public User getUser(String username) {
        return getUserPort.getUser(username);
    }
}
