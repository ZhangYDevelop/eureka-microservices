package com.zy.author.uaa.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by wangyunfei on 2017/6/12.
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/user")
    public Principal user(Principal user){
        return user;
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
