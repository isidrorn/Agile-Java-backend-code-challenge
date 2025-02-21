package com.irn.users.application.port.in;

import com.irn.users.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public interface GetUserUseCase {

    User getUser(String username);
}
