package com.irn.users.infrastructure.adapter.out.web.mapper;

import com.irn.users.domain.model.User;
import com.irn.users.infrastructure.adapter.out.web.model.Name;
import com.irn.users.infrastructure.adapter.out.web.model.RandomUserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface RandomUserMapper {

    @Mapping(target = "city" ,source = "location.city")
    @Mapping(target = "state" ,source = "location.state")
    @Mapping(target = "country" ,source = "location.country")
    @Mapping(target = "username", source = "name")
    @Mapping(target = "name", source = "name.first")
    @Mapping(target = "picture", source = "picture.medium")
    User toDomain(RandomUserDto user);

    List<User> toDomainList(List<RandomUserDto> userList);

    default String getUsername(Name name) {
        return name.getTitle() + name.getFirst() + name.getLast();
    }

}
