package com.xftxyz.weatherapi.pojo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WeatherObject {
    List<CityWeather> cityList;

    public WeatherObject(String jsonStr) {
        cityList = new ArrayList<>();

        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(jsonStr);

            JsonNode msg = root.get("msg");
            JsonNode cityArray = msg.get("city");

            for (JsonNode cityNode : cityArray) {
                JsonNode attributes = cityNode.get("@attributes");
                CityWeather cityWeather = mapper.convertValue(attributes, CityWeather.class);
                cityList.add(cityWeather);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<CityWeather> getCityList() {
        return cityList;
    }

}
