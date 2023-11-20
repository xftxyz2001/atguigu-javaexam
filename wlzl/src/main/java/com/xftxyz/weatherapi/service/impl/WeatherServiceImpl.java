package com.xftxyz.weatherapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.xftxyz.weatherapi.config.WeatherApiConfig;
import com.xftxyz.weatherapi.exception.BusinessException;
import com.xftxyz.weatherapi.pojo.WeatherObject;
import com.xftxyz.weatherapi.service.WeatherService;

import java.util.WeakHashMap;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    WeatherApiConfig weatherApiConfig;

    @Autowired
    RestTemplate restTemplate;

    // 弱引用缓存
     private WeakHashMap<String, WeatherObject> cache = new WeakHashMap<>();

    @Override
    public WeatherObject getWeather(String city, String month) {
        if (cache.containsKey(city + month)) {
            return cache.get(city + month);
        }

        // 获取配置信息
        String authorization = "APPCODE " + weatherApiConfig.getAppcode();
        String url = weatherApiConfig.getUrl();

        // 构造请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("'Authorization", authorization);


        // 构造请求体
        MultiValueMap<String, String> paraameterMap = new LinkedMultiValueMap<>();
        paraameterMap.add("src", city);
        paraameterMap.add("type", "1");
        paraameterMap.add("month", month);

        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(paraameterMap, headers);

        // 发送请求
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, httpEntity, String.class);

        // 如果请求失败，抛出异常
        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            throw new BusinessException("请求失败");
        }
        String body = responseEntity.getBody();
        WeatherObject weatherObject = new WeatherObject(body);
        // 缓存
        cache.put(city + month, weatherObject);

        return weatherObject;
    }

}
