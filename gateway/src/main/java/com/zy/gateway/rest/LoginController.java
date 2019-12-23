package com.zy.gateway.rest;

import com.zy.gateway.client.UaaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author zhangy
 * @Date 14:38 2019/12/23
 **/
@RestController
@RequestMapping("/api/oauth")
public class LoginController {

    private final  UaaClient uaaClient;

    public LoginController(UaaClient uaaClient) {
        this.uaaClient = uaaClient;
    }

    @RequestMapping("/login")
    public String login(@RequestParam Map map, HttpServletRequest req, HttpServletResponse resp ) {
        map.put("client_id","webapp" );
        map.put("client_secret", "webapp");
        map.put("grant_type", "password");
        String token = uaaClient.getAccessToke(map);
        resp.setHeader("access_token", token);
        return token;

    }
}
