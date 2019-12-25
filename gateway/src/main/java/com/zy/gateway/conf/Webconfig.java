package com.zy.gateway.conf;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @AUTHOR zhangy
 * 2019-12-22  10:19
 */
@EnableWebMvc
@Configuration
public class Webconfig  extends WebMvcConfigurerAdapter {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
      configurer.enable();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        super.addViewControllers(registry);

        registry.addViewController("/").setViewName("forward:/index");
        registry.addViewController("/index");
        registry.addViewController("/secure");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resource/**")
                .addResourceLocations("/resource/");
    }



    @Bean
    public static PropertySourcesPlaceholderConfigurer  getPlaceHolder() {
        return  new PropertySourcesPlaceholderConfigurer();
    }

    public RequestContextListener getContextListener() {
        return  new RequestContextListener();
    }

}
