package com.zy.gateway.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Author zhangy
 * @Date 14:32 2019/12/23
 **/
@FeignClient("${client.uaa}")
public interface UaaClient {

    @PostMapping("/oauth/token")
    String getAccessToke(@RequestParam Map map);
 }
