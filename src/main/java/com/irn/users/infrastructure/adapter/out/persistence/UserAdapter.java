package com.irn.users.infrastructure.adapter.out.persistence;

import com.irn.users.application.port.out.*;
import com.irn.users.domain.model.User;
import com.irn.users.infrastructure.adapter.out.persistence.mapper.UserEntityMapper;
import com.irn.users.infrastructure.adapter.out.persistence.model.UserEntity;
import com.irn.users.infrastructure.adapter.out.persistence.repository.UserPagingRepository;
import com.irn.users.infrastructure.adapter.out.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserAdapter implements
        GetUserListPort,
        CreateUserPort,
        UpdateUserPort,
        GetUserPort,
        DeleteUserPort,
        SaveUsersPort {

    private final UserEntityMapper mapper;
    private final UserRepository userRepository;
    private final UserPagingRepository userPagingRepository;

    @Override
    public User getUser(String username) {
        return mapper.toDomain(findUser(username));
    }

    private UserEntity findUser(String username) {
        return userRepository.findByUsername(username).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "User: " + username + " not found"));
    }

    @Override
    public User createUser(User user) {
        Optional<UserEntity> userEntity = userRepository.findByUsername(user.getUsername());
        if (userEntity.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User: " + user.getUsername() + " already exists");
        }

        return mapper.toDomain(
                userRepository.save(mapper.toEntity(user)));
    }


    @Override
    public User updateUser(User newData) {

        UserEntity old = findUser(newData.getUsername());
        UserEntity updated = mapper.toEntity(newData);
        updated.setId(old.getId());

        return mapper.toDomain(userRepository.save(updated));
    }

    @Override
    public void deleteUser(String username) {
        userRepository.delete(findUser(username));
    }

    @Override
    public List<User> saveUsers(List<User> newData) {
        return mapper.toDomainList(
                userRepository.saveAll(mapper.toEntityList(newData)));
    }

    @Override
    public List<User> getUserList() {
        List<UserEntity> userEntityList = userRepository.findAll();

        return mapper.toDomainList(userEntityList);
    }

    @Override
    public Page<User> getUserPage(Pageable pageable) {
        return mapper.toDomainPage(userPagingRepository.findAll(pageable));
    }
}
