package com.irn.users.application.port.in;

import org.springframework.stereotype.Component;

@Component
public interface DeleteUserUseCase {

    void deleteUser(String username);
}
