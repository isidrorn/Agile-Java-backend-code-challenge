package com.irn.users.application.port.in;

import com.irn.users.domain.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


@Component
public interface GetUserTreeUseCase {

    Map<String, Map<String, Map<String, List<User>>>> getUserTree();
}
