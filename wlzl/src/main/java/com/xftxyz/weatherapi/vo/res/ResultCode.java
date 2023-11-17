package com.xftxyz.weatherapi.vo.res;

public enum ResultCode {
    // 未知错误
    UNKNOWN_ERROR(-1, "未知错误"),
    // 成功
    SUCCESS(0, "成功"),
    // 失败
    FAIL(1, "失败"),

    // 其他错误
    PARAM_ERROR(500, "非法参数"),
    // 参数校验错误
    PARAM_VALID_ERROR(501, "参数校验错误");

    private Integer code;
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
