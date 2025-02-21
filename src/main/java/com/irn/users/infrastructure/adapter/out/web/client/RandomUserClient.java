package com.irn.users.infrastructure.adapter.out.web.client;

import com.irn.users.infrastructure.adapter.out.web.model.RandomUserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "randomUserClient", url = "${feign.client.randomuser.base-url}")
public interface RandomUserClient {


    @GetMapping("?inc=gender,name,location,email,picture&result={resultNumber}")
    List<RandomUserDto> generateUsers(@RequestParam int resultNumber);

}
