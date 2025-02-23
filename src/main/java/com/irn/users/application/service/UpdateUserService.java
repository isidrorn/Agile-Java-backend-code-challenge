package com.irn.users.application.service;

import com.irn.users.application.port.in.UpdateUserUseCase;
import com.irn.users.application.port.out.UpdateUserPort;
import com.irn.users.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class UpdateUserService implements UpdateUserUseCase {

    private final UpdateUserPort updateUserPort;

    @Override
    public User updateUser(User newData) {
        return updateUserPort.updateUser(newData);
    }
}
