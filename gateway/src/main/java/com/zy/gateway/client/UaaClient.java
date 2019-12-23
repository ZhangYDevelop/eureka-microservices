package com.zy.gateway.client;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Author zhangy
 * @Date 14:32 2019/12/23
 **/
@FeignClient("${client.uaa}")
public interface UaaClient {
}
