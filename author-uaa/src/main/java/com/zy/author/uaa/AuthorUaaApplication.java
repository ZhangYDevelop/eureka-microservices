package com.zy.author.uaa;

/**
 * @AUTHOR zhangy
 * 2019-12-15  22:45
 */

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @AUTHOR zhangy
 * 2019-12-14  12:36
 * 认证服务器
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AuthorUaaApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthorUaaApplication.class, args);
    }
}
