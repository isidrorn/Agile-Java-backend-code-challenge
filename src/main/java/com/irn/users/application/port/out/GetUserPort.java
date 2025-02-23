package com.irn.users.application.port.out;

import com.irn.users.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public interface GetUserPort {

    User getUser(String username);
}
