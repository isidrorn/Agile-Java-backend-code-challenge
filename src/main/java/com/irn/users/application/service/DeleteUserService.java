package com.irn.users.application.service;

import com.irn.users.application.port.in.DeleteUserUseCase;
import com.irn.users.application.port.out.DeleteUserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class DeleteUserService implements DeleteUserUseCase {

    private final DeleteUserPort deleteUserPort;

    @Override
    public void deleteUser(String username) {
        deleteUserPort.deleteUser(username);
    }
}
