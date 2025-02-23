package com.irn.users.application.service;

import com.irn.users.application.port.in.GetUserTreeUseCase;
import com.irn.users.application.port.out.GetUserListPort;
import com.irn.users.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequiredArgsConstructor
@Service
public class UsersTreeViewService implements GetUserTreeUseCase {

    private final GetUserListPort getUserListPort;

    public Map<String, Map<String, Map<String, List<User>>>> getUserTree() {

        var users = getUserListPort.getUserList();

        //tree logic
        Map<String, Map<String, Map<String, List<User>>>> userTree = new HashMap<>();

        for (User user : users) {
            userTree.computeIfAbsent(user.getCountry(), k -> new HashMap<>())
                    .computeIfAbsent(user.getState(), k -> new HashMap<>())
                    .computeIfAbsent(user.getCity(), k -> new ArrayList<>())
                    .add(user);
        }

        return userTree;
    }
}

