package com.irn.users.application.port.out;

import org.springframework.stereotype.Component;

@Component
public interface DeleteUserPort {

    void deleteUser(String username);
}
