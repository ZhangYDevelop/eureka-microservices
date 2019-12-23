package com.zy.gateway.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhangy
 * @Date 14:38 2019/12/23
 **/
@RestController
@RequestMapping("/api/oauth")
public class LoginController {

    @RequestMapping("login")
    public void login() {

    }
}
