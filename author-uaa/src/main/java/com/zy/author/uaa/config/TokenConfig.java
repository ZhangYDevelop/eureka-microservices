package com.zy.author.uaa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @AUTHOR zhangy
 * 2019-12-22  18:12
 */
@Configuration
public class TokenConfig {

    private final static String SECRET = "UAA-SECRET";

    /**
     * 基于内存存储token
     * @return
     */
//    @Bean
//    public TokenStore getTokenStore() {
//        return  new InMemoryTokenStore();
//    }


    @Bean
    public TokenStore getJwtTokenStore() {
        return  new JwtTokenStore(accessTokenConvert());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConvert() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey(SECRET);
        return  jwtAccessTokenConverter;

    }
}
