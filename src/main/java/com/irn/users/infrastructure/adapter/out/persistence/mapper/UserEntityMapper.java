package com.irn.users.infrastructure.adapter.out.persistence.mapper;

import com.irn.users.domain.model.User;
import com.irn.users.infrastructure.adapter.out.persistence.model.UserEntity;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {

    User toDomain(UserEntity user);

    UserEntity toEntity(User user);

    List<User> toDomainList(List<UserEntity> userList);

    List<UserEntity> toEntityList(List<User> userList);

//    Page<User> toDomainPage(Page<UserEntity> userList);

    default Page<User> toDomainPage(Page<UserEntity> data) {
        return data.map(this::toDomain);
    }


}
