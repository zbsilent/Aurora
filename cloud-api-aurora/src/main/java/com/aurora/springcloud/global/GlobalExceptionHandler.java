package com.aurora.springcloud.global;

import com.aurora.springcloud.common.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zbsilent
 * @date 2021年06月09日 4:18 上午
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    public CommonResult<String> exceptionHandler(HttpServletRequest request, Exception exception) throws Exception {
        log.error("url:{}|errorMsg:{}", request.getRequestURI(), exception.getMessage(), exception);
        CommonResult<String> stringCommonResult = new CommonResult<>();
        //Map<String, Object> result = new HashMap<>(3);
        stringCommonResult.setCode(500);
        stringCommonResult.setMessage(exception.getMessage());
        stringCommonResult.setData(request.getRequestURL().toString());
        return stringCommonResult;
    }
}
