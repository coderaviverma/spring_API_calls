package com.bluebirds.shashiofficework;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HttpUtils {

    @Bean
    public RestTemplate getRestTemplate(){

        System.out.println("Get Rest Template called");
        return new RestTemplate();
    }
}
