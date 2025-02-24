package com.irn.users.infrastructure.adapter.in.web.controller.mapper;

import com.irn.users.domain.model.User;
import com.irn.users.infrastructure.adapter.in.web.controller.model.CreateUserRequestDto;
import com.irn.users.infrastructure.adapter.in.web.controller.model.UpdateUserRequestDto;
import com.irn.users.infrastructure.adapter.in.web.controller.model.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;


@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "city" ,source = "location.city")
    @Mapping(target = "state" ,source = "location.state")
    @Mapping(target = "country" ,source = "location.country")
    User toDomain(CreateUserRequestDto user);

    @Mapping(target = "city" ,source = "user.location.city")
    @Mapping(target = "state" ,source = "user.location.state")
    @Mapping(target = "country" ,source = "user.location.country")
    @Mapping(target = "username", source = "username")
    User toDomain(UpdateUserRequestDto user, String username);

    @Mapping(target = "location.city" ,source = "city")
    @Mapping(target = "location.state" ,source = "state")
    @Mapping(target = "location.country" ,source = "city")
    UserResponseDto toDto(User user);

    List<UserResponseDto> toDtoList(List<User> userList);

    Map<String, Map<String, Map<String, List<UserResponseDto>>>> toDtoTree(Map<String, Map<String, Map<String, List<User>>>> tree);

    Map<String,Map<String,List<UserResponseDto>>> mapStateAndCityUserMap(Map<String,Map<String,List<User>>> value);

    Map<String,List<UserResponseDto>> mapCityUserMap(Map<String,List<User>> value);

    default Page<UserResponseDto> toDtoPage(Page<User> data) {
        return data.map(this::toDto);
    }
}
