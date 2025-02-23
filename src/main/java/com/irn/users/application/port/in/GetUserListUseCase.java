package com.irn.users.application.port.in;

import com.irn.users.domain.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public interface GetUserListUseCase {

    Page<User> getUserList(Pageable pageable);
}
