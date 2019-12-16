package com.zy.eurekaserver.conf;

import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.annotation.PostConstruct;

/**
 * @Author zhangy
 * @Date 16:39 2019/12/13
 **/
@Configuration
@EnableWebSecurity
public class JWTSecurityConfiguration extends WebSecurityConfigurerAdapter {


    private final String username;

    private final String password;

    private final String[] roles;

    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    public JWTSecurityConfiguration(@Value("${spring.security.user.name}") String username,
                                    @Value("${spring.security.user.password}") String password,
                                    @Value("${spring.security.user.roles}") String[] roles,
                                    AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }







    @PostConstruct
    public void init() {
        try {
            authenticationManagerBuilder
                    .userDetailsService(userDetailsService())
                    .passwordEncoder(passwordEncoder());
        } catch (Exception e) {
            throw new BeanInitializationException("Security configuration failed", e);
        }
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(
                User.withUsername(username)
                        .password(passwordEncoder().encode(password))
                        .roles(roles)
                        .build());
        return manager;
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        //httpSecurity.csrf().disable();
        httpSecurity
                .exceptionHandling()
                .and()
                .csrf()
                .disable()
                .headers()
                .frameOptions()
                .disable()
                .and()
                .httpBasic()
                //.realmName("JHipster Registry")
                .and()
                .authorizeRequests()
                .antMatchers("/eureka/**").hasAuthority("admin")
//                .antMatchers("/config/**").hasAuthority("admin")
//                .antMatchers("/api/authenticate").permitAll()
//                .antMatchers("/api/profile-info").permitAll()
//                .antMatchers("/api/**").authenticated()
//                .antMatchers("/management/health").permitAll()
//                .antMatchers("/management/**").hasAuthority("admin")
//                .antMatchers("/v2/api-docs/**").permitAll()
//                .antMatchers("/swagger-resources/configuration/**").permitAll()
                .antMatchers("/swagger-ui/index.html").hasAuthority("admin")
                .antMatchers("/*").permitAll()
                .anyRequest().authenticated();
    }
}
