package com.irn.users.application.port.out;

import com.irn.users.domain.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GetUserListPort {

    List<User> getUserList();

    Page<User> getUserPage(Pageable pageable);
}
