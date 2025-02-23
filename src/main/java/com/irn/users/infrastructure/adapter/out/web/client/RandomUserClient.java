package com.irn.users.infrastructure.adapter.out.web.client;

import com.irn.users.infrastructure.adapter.out.web.model.RandomUserResponseDto;
import org.springframework.cloud.openfeign.CollectionFormat;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "random-user-client", url = "${feign.client.randomuser.base-url}")
public interface RandomUserClient {

    String FIX_PARAMS = "inc=gender,name,location,email,picture&noinfo";

    @GetMapping("/?"+FIX_PARAMS)
    @CollectionFormat(feign.CollectionFormat.CSV)
    RandomUserResponseDto generateUsers(@RequestParam("results") int resultNumber );

}
