package com.zy.author.uaa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.jws.Oneway;

/**
 * Created by wangyunfei on 2017/6/9.
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

//    @Autowired
//    private UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
//    @Autowired
//    private RedisConnectionFactory connectionFactory;
//
//
//    @Bean
//    public RedisTokenStore tokenStore() {
//        return new RedisTokenStore(connectionFactory);
//    }
//
//
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints
//                .authenticationManager(authenticationManager)
//                .userDetailsService(userDetailsService)//若无，refresh_token会有UserDetailsService is required错误
//                .tokenStore(tokenStore());
//    }
//
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                // 开启/oauth/token_key验证端口无权限访问
                .tokenKeyAccess("permitAll()")
                // 开启/oauth/check_token验证端口认证权限访问
                .checkTokenAccess("permitAll()")
                .allowFormAuthenticationForClients();
    }

    @Autowired
    private  PasswordEncoder passwordEncoder;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // 配置客户端
        clients.inMemory()
                .withClient("webapp")
                .scopes("all")
                // 必须编码
                .secret(passwordEncoder.encode("webapp"))
                .autoApprove(true)
                .authorizedGrantTypes("password", "authorization_code", "refresh_token")
                .redirectUris("http://www.baidu.com");
    }


    /**
     * 注入authenticationManager
     * 来支持 password grant type
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
    }
}
