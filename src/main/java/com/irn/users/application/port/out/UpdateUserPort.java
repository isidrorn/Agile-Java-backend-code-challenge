package com.irn.users.application.port.out;

import com.irn.users.domain.model.User;

public interface UpdateUserPort {

    User updateUser(User user);
}
