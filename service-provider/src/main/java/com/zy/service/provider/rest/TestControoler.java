package com.zy.service.provider.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @AUTHOR zhangy
 * 2019-12-13  22:44
 */
@RestController
@RequestMapping("/api")
public class TestControoler {

    @GetMapping("hello")
    public String getMessage(){
        return "hello";
    }
}
