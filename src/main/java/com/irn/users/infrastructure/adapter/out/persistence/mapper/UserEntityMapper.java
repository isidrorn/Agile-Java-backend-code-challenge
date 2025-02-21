package com.irn.users.infrastructure.adapter.out.persistence.mapper;

import com.irn.users.domain.model.User;
import com.irn.users.infrastructure.adapter.out.persistence.model.UserEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {

    User toDomain(UserEntity user);

    UserEntity toEntity(User user);
}
