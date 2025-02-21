package com.irn.users.application.service;

import com.irn.users.application.port.in.GetUserUseCase;
import com.irn.users.domain.model.User;
import com.irn.users.infrastructure.adapter.out.persistence.mapper.UserEntityMapper;
import com.irn.users.infrastructure.adapter.out.persistence.model.UserEntity;
import com.irn.users.infrastructure.adapter.out.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@RequiredArgsConstructor
@Service
public class GetUserService implements GetUserUseCase {

    private final UserRepository userRepository;
    private final UserEntityMapper mapper;

    @Override
    public User getUser(String username) {
        UserEntity userEntity =  userRepository.findByUsername(username).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "User: " + username + " not found"));

        return mapper.toDomain(userEntity);
    }
}
