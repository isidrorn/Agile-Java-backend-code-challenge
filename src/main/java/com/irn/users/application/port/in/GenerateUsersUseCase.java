package com.irn.users.application.port.in;

import com.irn.users.domain.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GenerateUsersUseCase {

    List<User> generateUsers(int resultNumber);
}
