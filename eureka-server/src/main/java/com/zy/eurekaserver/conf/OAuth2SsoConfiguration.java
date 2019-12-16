package com.zy.eurekaserver.conf;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author zhangy
 * @Date 10:21 2019/12/16
 **/
//@EnableOAuth2Sso
//@Configuration
public class OAuth2SsoConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .headers()
                .frameOptions()
                .disable()
                .and()
                .authorizeRequests()
                .antMatchers("/services/**").authenticated()
                .antMatchers("/eureka/**").hasAuthority("admin")
                .antMatchers("/api/profile-info").permitAll()
                .antMatchers("/api/**").authenticated()
                .antMatchers("/config/**").hasAuthority("admin")
                .antMatchers("/management/health").permitAll()
                .antMatchers("/management/**").hasAuthority("admin")
                .anyRequest().permitAll();
    }

}
