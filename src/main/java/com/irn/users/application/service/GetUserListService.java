package com.irn.users.application.service;

import com.irn.users.application.port.in.GetUserListUseCase;
import com.irn.users.application.port.out.GetUserListPort;
import com.irn.users.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class GetUserListService implements GetUserListUseCase {

    private final GetUserListPort getUserListPort;

    @Override
    public Page<User> getUserList(Pageable pageable) {
        return getUserListPort.getUserPage(pageable);
    }
}
