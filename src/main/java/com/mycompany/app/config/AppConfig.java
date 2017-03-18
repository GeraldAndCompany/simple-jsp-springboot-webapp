package com.mycompany.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@EnableAutoConfiguration
@EnableWebMvc
@ComponentScan("com.mycompany.app")
public class AppConfig {
    @Value("${spring.mvc.view.prefix:/WEB-INF/jsp}")
    String mvcViewPrefix;
    @Value("${spring.mvc.view.suffix:.jsp}")
    String mvcViewSuffix;

    //sets up resolver for jsp
    @Bean
    public UrlBasedViewResolver setupViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix(mvcViewPrefix);
        resolver.setSuffix(mvcViewSuffix);
        resolver.setViewClass(JstlView.class);
        return resolver;
    }
}
