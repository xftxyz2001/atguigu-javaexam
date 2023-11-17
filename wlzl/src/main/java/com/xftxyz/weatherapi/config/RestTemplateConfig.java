package com.xftxyz.weatherapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    // RestTemplate相关配置
    @Bean
    RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(simpleFactory());
        return restTemplate;
    }

    @Bean
    ClientHttpRequestFactory simpleFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        // 响应超时时间20s
        factory.setReadTimeout(20 * 1000);
        // 连接超时10s
        factory.setConnectTimeout(10 * 1000);
        return factory;
    }

}
