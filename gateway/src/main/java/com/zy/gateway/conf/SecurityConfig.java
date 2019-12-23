package com.zy.gateway.conf;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @AUTHOR zhangy
 * 2019-12-15  10:42
 */
@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.antMatcher("/**")
//                .authorizeRequests()
//                .antMatchers("/", "/login**","/api/oauth/login")
//                .permitAll()
//                .anyRequest()
//                .authenticated();

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/login**","/api/oauth/login")
                .permitAll()
                .anyRequest().authenticated();

    }

}
