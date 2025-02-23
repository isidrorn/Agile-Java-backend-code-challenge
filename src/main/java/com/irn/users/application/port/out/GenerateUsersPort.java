package com.irn.users.application.port.out;

import com.irn.users.domain.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GenerateUsersPort {

    List<User> generateUsers(int resultNumber);
}
