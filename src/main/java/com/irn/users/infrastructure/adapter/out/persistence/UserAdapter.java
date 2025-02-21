package com.irn.users.infrastructure.adapter.out.persistence;

import com.irn.users.application.port.out.CreateUserPort;
import com.irn.users.domain.model.User;
import com.irn.users.infrastructure.adapter.out.persistence.mapper.UserEntityMapper;
import com.irn.users.infrastructure.adapter.out.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserAdapter implements CreateUserPort {

    private final UserEntityMapper userEntityMapper;
    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {

        return userEntityMapper.toDomain(
                userRepository.save(userEntityMapper.toEntity(user)));
    }


}
