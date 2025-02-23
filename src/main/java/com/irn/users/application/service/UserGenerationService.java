package com.irn.users.application.service;

import com.irn.users.application.port.in.GenerateUsersUseCase;
import com.irn.users.application.port.out.GenerateUsersPort;
import com.irn.users.application.port.out.SaveUsersPort;
import com.irn.users.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class UserGenerationService implements GenerateUsersUseCase {

    private final SaveUsersPort saveUsersPort;
    private final GenerateUsersPort generateUsersPort;

    @Override
    public List<User> generateUsers(int numberOfUsers) {

        var users = generateUsersPort.generateUsers(numberOfUsers);
        return saveUsersPort.saveUsers(users);
    }
}
