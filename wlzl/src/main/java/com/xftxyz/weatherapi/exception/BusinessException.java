package com.xftxyz.weatherapi.exception;

import com.xftxyz.weatherapi.vo.res.Result;
import com.xftxyz.weatherapi.vo.res.ResultCode;

public class BusinessException extends RuntimeException {

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }

    public Result<Object> handle() {
        return Result.error(ResultCode.UNKNOWN_ERROR.getCode(), this.getMessage());
    }
}
