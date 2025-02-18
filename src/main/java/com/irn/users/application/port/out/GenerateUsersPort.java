package com.irn.users.application.port.out;

import com.irn.users.domain.model.User;

import java.util.List;

public interface GenerateUsersPort {

    List<User> generateUsers(int resultNumber);
}
