package com.zy.author.uaa.config;

import com.zy.author.uaa.security.DomainUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * Created by wangyunfei on 2017/6/9.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//
    @Bean
    public UserDetailsService userDetailsServices(){
        return new DomainUserDetailsService();
    }
//
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
//
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsServices())
                .passwordEncoder(passwordEncoder());
    }
////
////    @Bean
////    public SecurityEvaluationContextExtension securityEvaluationContextExtension() {
////        return new SecurityEvaluationContextExtension();
////    }
////

// 不定义没有password grant_type
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
              .csrf().disable()
              .authorizeRequests()
              .antMatchers("/oauth/**", "/logout").permitAll()
              .antMatchers("/login").permitAll()
              .antMatchers("/v2/api-docs").permitAll()
              .antMatchers("/swagger-ui.html").permitAll()
              .antMatchers("/api/user").permitAll()
              .anyRequest().authenticated()
                .and().formLogin();
    }

}
