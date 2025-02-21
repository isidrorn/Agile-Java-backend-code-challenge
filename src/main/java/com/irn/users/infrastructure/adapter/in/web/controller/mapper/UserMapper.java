package com.irn.users.infrastructure.adapter.in.web.controller.mapper;

import com.irn.users.domain.model.User;
import com.irn.users.infrastructure.adapter.in.web.controller.model.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface UserMapper {


    @Mapping(target = "city" ,source = "location.city")
    @Mapping(target = "state" ,source = "location.state")
    @Mapping(target = "country" ,source = "location.city")
    User toDomain(UserResponseDto user);

    @Mapping(target = "location.city" ,source = "city")
    @Mapping(target = "location.state" ,source = "state")
    @Mapping(target = "location.country" ,source = "city")
    UserResponseDto toDto(User user);
}
