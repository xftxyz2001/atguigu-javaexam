package com.xftxyz.weatherapi.exception.advice;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.xftxyz.weatherapi.exception.BusinessException;
import com.xftxyz.weatherapi.vo.res.Result;
import com.xftxyz.weatherapi.vo.res.ResultCode;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class CustomerExceptionHandler {
    // 业务异常
    @ExceptionHandler(BusinessException.class)
    public Result<Object> handleBusinessException(BusinessException e) {
        return e.handle();
    }

    // 请求参数校验失败异常
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<Object> handleValidationException(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<String> errorMessages = result.getFieldErrors().stream()
                .map(error -> String.format("%s : %s", error.getField(), error.getDefaultMessage()))
                .collect(Collectors.toList());
        return Result.error(ResultCode.PARAM_VALID_ERROR.getCode(), "请求参数校验失败" + errorMessages);
    }

    // @ExceptionHandler(ConstraintViolationException.class)
    // public Result<Object> handleConstraintViolationException(ConstraintViolationException e) {
    //     Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
    //     List<String> errorMessages = violations.stream()
    //             .map(violation -> String.format("%s : %s", violation.getPropertyPath(), violation.getMessage()))
    //             .collect(Collectors.toList());
    //     return Result.error(ResultCode.PARAM_VALID_ERROR.getCode(), "请求参数校验失败" + errorMessages);
    // }

    // 请求参数缺失
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Result<Object> handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        return Result.error(ResultCode.PARAM_ERROR.getCode(),
                ResultCode.PARAM_ERROR.getMessage() + ": " + e.getParameterName() + "不能为空");
    }

    // HTTP消息不可读异常
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return Result.error(ResultCode.PARAM_ERROR.getCode(), ResultCode.PARAM_ERROR.getMessage());
    }

    // 请求参数异常
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public Result<Object> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        return Result.error(ResultCode.PARAM_ERROR.getCode(),
                ResultCode.PARAM_ERROR.getMessage() + ": " + e.getName() + "应为" + e.getRequiredType());
    }

    // 未知异常
    @ExceptionHandler(Exception.class)
    public Result<Object> handleException(Exception e) {
        log.error("出现未知异常：", e);
        return Result.error(ResultCode.UNKNOWN_ERROR.getCode(), e.getMessage());
    }
}
