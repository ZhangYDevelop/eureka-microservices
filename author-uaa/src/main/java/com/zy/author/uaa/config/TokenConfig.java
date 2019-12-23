package com.zy.author.uaa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * @AUTHOR zhangy
 * 2019-12-22  18:12
 */
@Configuration
public class TokenConfig {

    @Bean
    public TokenStore getTokenStore() {
        return  new InMemoryTokenStore();
    }
}
