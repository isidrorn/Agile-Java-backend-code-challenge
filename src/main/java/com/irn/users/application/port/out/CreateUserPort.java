package com.irn.users.application.port.out;

import com.irn.users.domain.model.User;

public interface CreateUserPort {

    User createUser(User user);
}
