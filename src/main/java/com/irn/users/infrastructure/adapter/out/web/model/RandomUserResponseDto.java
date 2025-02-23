package com.irn.users.infrastructure.adapter.out.web.model;

import lombok.Data;

import java.util.List;

@Data
public class RandomUserResponseDto {
    private List<RandomUserDto> results;
}
