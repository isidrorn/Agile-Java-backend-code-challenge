package com.irn.users.application.service;

import com.irn.users.application.port.out.GetUserListPort;
import com.irn.users.domain.model.User;
import org.instancio.Instancio;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class GetUserListServiceTest {

    @InjectMocks
    private GetUserListService getUserListService;

    @Mock private GetUserListPort getUserListPort;

    @BeforeAll
    public static void beforeAll() {
        MockitoAnnotations.openMocks(GetUserListServiceTest.class);
    }

    @Test
    void getUserList() {
        var userList = Instancio.createList(User.class);
        Pageable pageable = PageRequest.of(0, 20);
        Page<User> userPage = new PageImpl<>(userList, pageable, userList.size());

        given(getUserListPort.getUserPage(pageable)).willReturn(userPage);

        getUserListService.getUserList(pageable);

        Mockito.verify(getUserListPort, Mockito.atLeastOnce()).getUserPage(Mockito.any(Pageable.class));

    }
}