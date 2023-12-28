package com.quinbay.customer.config;

import com.quinbay.customer.controller.LoginController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
    public class webconfig implements WebMvcConfigurer {


    @Autowired
    LoginController loginController;

        @Bean
        public RestTemplate getRestTemplate()
        {
            return new RestTemplate();
        }

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(loginController).addPathPatterns("*");
        }
    }


