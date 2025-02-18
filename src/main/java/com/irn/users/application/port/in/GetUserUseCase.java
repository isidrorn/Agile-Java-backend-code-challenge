package com.irn.users.application.port.in;

import com.irn.users.domain.model.User;

public interface GetUserUseCase {

    User getUser(String username);
}
