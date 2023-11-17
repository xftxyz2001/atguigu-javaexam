package com.xftxyz.weatherapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xftxyz.weatherapi.pojo.WeatherObject;
import com.xftxyz.weatherapi.service.WeatherService;
import com.xftxyz.weatherapi.vo.req.WeatherReqBody;

@RestController
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @RequestMapping("/weather")
    // curl -i -k -X POST 'http://localhost:8080/weather' -H "Content-Type:
    // application/json" -d '{"src":"shanxi", "month":"201907"}'
    public WeatherObject getWeather(@RequestBody WeatherReqBody weatherReqBody) {

        // 获取请求参数
        String src = weatherReqBody.getSrc();
        String month = weatherReqBody.getMonth();

        // 调用服务
        WeatherObject weather = weatherService.getWeather(src, month);
        return weather;

    }
}
