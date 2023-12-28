package com.quinbay.customer.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@CrossOrigin(origins="*")
    public class webconfig{

        @Bean
        public RestTemplate getRestTemplate()
        {
            return new RestTemplate();
        }

    }


