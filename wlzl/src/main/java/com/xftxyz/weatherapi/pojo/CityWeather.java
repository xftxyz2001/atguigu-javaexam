package com.xftxyz.weatherapi.pojo;

public class CityWeather {
    String cityX; // 城市经度
    String cityY; // 城市纬度
    String cityname; // 城市名
    String centername; // 城市中心名
    String fontColor; // 字体颜色
    String pyName; // 城市拼音

    String state1; // 天气状况
    String state2; // 天气状况
    String stateDetailed; // 天气状况描述

    String tem1; // 最低温度
    String tem2; // 最高温度
    String temNow; // 当前温度

    String windState; // 风向
    String windDir; // 风向
    String windPower; // 风力
    String humidity; // 湿度

    String time; // 发布时间
    String url; // 天气预报url

    public String getCityX() {
        return cityX;
    }

    public void setCityX(String cityX) {
        this.cityX = cityX;
    }

    public String getCityY() {
        return cityY;
    }

    public void setCityY(String cityY) {
        this.cityY = cityY;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getCentername() {
        return centername;
    }

    public void setCentername(String centername) {
        this.centername = centername;
    }

    public String getFontColor() {
        return fontColor;
    }

    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

    public String getPyName() {
        return pyName;
    }

    public void setPyName(String pyName) {
        this.pyName = pyName;
    }

    public String getState1() {
        return state1;
    }

    public void setState1(String state1) {
        this.state1 = state1;
    }

    public String getState2() {
        return state2;
    }

    public void setState2(String state2) {
        this.state2 = state2;
    }

    public String getStateDetailed() {
        return stateDetailed;
    }

    public void setStateDetailed(String stateDetailed) {
        this.stateDetailed = stateDetailed;
    }

    public String getTem1() {
        return tem1;
    }

    public void setTem1(String tem1) {
        this.tem1 = tem1;
    }

    public String getTem2() {
        return tem2;
    }

    public void setTem2(String tem2) {
        this.tem2 = tem2;
    }

    public String getTemNow() {
        return temNow;
    }

    public void setTemNow(String temNow) {
        this.temNow = temNow;
    }

    public String getWindState() {
        return windState;
    }

    public void setWindState(String windState) {
        this.windState = windState;
    }

    public String getWindDir() {
        return windDir;
    }

    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }

    public String getWindPower() {
        return windPower;
    }

    public void setWindPower(String windPower) {
        this.windPower = windPower;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cityX == null) ? 0 : cityX.hashCode());
        result = prime * result + ((cityY == null) ? 0 : cityY.hashCode());
        result = prime * result + ((cityname == null) ? 0 : cityname.hashCode());
        result = prime * result + ((centername == null) ? 0 : centername.hashCode());
        result = prime * result + ((fontColor == null) ? 0 : fontColor.hashCode());
        result = prime * result + ((pyName == null) ? 0 : pyName.hashCode());
        result = prime * result + ((state1 == null) ? 0 : state1.hashCode());
        result = prime * result + ((state2 == null) ? 0 : state2.hashCode());
        result = prime * result + ((stateDetailed == null) ? 0 : stateDetailed.hashCode());
        result = prime * result + ((tem1 == null) ? 0 : tem1.hashCode());
        result = prime * result + ((tem2 == null) ? 0 : tem2.hashCode());
        result = prime * result + ((temNow == null) ? 0 : temNow.hashCode());
        result = prime * result + ((windState == null) ? 0 : windState.hashCode());
        result = prime * result + ((windDir == null) ? 0 : windDir.hashCode());
        result = prime * result + ((windPower == null) ? 0 : windPower.hashCode());
        result = prime * result + ((humidity == null) ? 0 : humidity.hashCode());
        result = prime * result + ((time == null) ? 0 : time.hashCode());
        result = prime * result + ((url == null) ? 0 : url.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CityWeather other = (CityWeather) obj;
        if (cityX == null) {
            if (other.cityX != null)
                return false;
        } else if (!cityX.equals(other.cityX))
            return false;
        if (cityY == null) {
            if (other.cityY != null)
                return false;
        } else if (!cityY.equals(other.cityY))
            return false;
        if (cityname == null) {
            if (other.cityname != null)
                return false;
        } else if (!cityname.equals(other.cityname))
            return false;
        if (centername == null) {
            if (other.centername != null)
                return false;
        } else if (!centername.equals(other.centername))
            return false;
        if (fontColor == null) {
            if (other.fontColor != null)
                return false;
        } else if (!fontColor.equals(other.fontColor))
            return false;
        if (pyName == null) {
            if (other.pyName != null)
                return false;
        } else if (!pyName.equals(other.pyName))
            return false;
        if (state1 == null) {
            if (other.state1 != null)
                return false;
        } else if (!state1.equals(other.state1))
            return false;
        if (state2 == null) {
            if (other.state2 != null)
                return false;
        } else if (!state2.equals(other.state2))
            return false;
        if (stateDetailed == null) {
            if (other.stateDetailed != null)
                return false;
        } else if (!stateDetailed.equals(other.stateDetailed))
            return false;
        if (tem1 == null) {
            if (other.tem1 != null)
                return false;
        } else if (!tem1.equals(other.tem1))
            return false;
        if (tem2 == null) {
            if (other.tem2 != null)
                return false;
        } else if (!tem2.equals(other.tem2))
            return false;
        if (temNow == null) {
            if (other.temNow != null)
                return false;
        } else if (!temNow.equals(other.temNow))
            return false;
        if (windState == null) {
            if (other.windState != null)
                return false;
        } else if (!windState.equals(other.windState))
            return false;
        if (windDir == null) {
            if (other.windDir != null)
                return false;
        } else if (!windDir.equals(other.windDir))
            return false;
        if (windPower == null) {
            if (other.windPower != null)
                return false;
        } else if (!windPower.equals(other.windPower))
            return false;
        if (humidity == null) {
            if (other.humidity != null)
                return false;
        } else if (!humidity.equals(other.humidity))
            return false;
        if (time == null) {
            if (other.time != null)
                return false;
        } else if (!time.equals(other.time))
            return false;
        if (url == null) {
            if (other.url != null)
                return false;
        } else if (!url.equals(other.url))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CityWeather [cityX=" + cityX + ", cityY=" + cityY + ", cityname=" + cityname + ", centername="
                + centername + ", fontColor=" + fontColor + ", pyName=" + pyName + ", state1=" + state1 + ", state2="
                + state2 + ", stateDetailed=" + stateDetailed + ", tem1=" + tem1 + ", tem2=" + tem2 + ", temNow="
                + temNow + ", windState=" + windState + ", windDir=" + windDir + ", windPower=" + windPower
                + ", humidity=" + humidity + ", time=" + time + ", url=" + url + "]";
    }

}
