package com.irn.users.infrastructure.adapter.out.web;

import com.irn.users.application.port.out.GenerateUsersPort;
import com.irn.users.domain.model.User;
import com.irn.users.infrastructure.adapter.out.web.client.RandomUserClient;
import com.irn.users.infrastructure.adapter.out.web.mapper.RandomUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RandomUserAdapter implements GenerateUsersPort {

    private final RandomUserClient randomUserClient;
    private final RandomUserMapper randomUserMapper;

    @Override
    public List<User> generateUsers(int numberOfUsers) {
        return randomUserMapper.toDomainList(
                randomUserClient.generateUsers(numberOfUsers).getResults());
    }
}
