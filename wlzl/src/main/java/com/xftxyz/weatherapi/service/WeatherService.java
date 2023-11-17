package com.xftxyz.weatherapi.service;

import com.xftxyz.weatherapi.pojo.WeatherObject;

public interface WeatherService {
    /**
     * 获取天气信息
     * 
     * @param city  城市名（拼音）
     * @param month 月份（格式：201907）
     * @return 天气信息（JSON格式）
     */
    public WeatherObject getWeather(String city, String month);
}
