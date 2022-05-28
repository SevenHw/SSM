package com.seven.core.response.advice;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.seven.core.response.JSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 全局统一返回
 */
@Slf4j
// 这里只扫描本项目的，防止把Swagger等第三方的拦截
@RestControllerAdvice(basePackages = "com.seven.matlab")
public class MyGlobalResponseAdvice implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof JSONResult) {
            JSONResult result = (JSONResult) body;
            if (result.isSuccess() && ObjectUtil.isEmpty(result.getCode())) { // 修复成功，但是没有code
                result.setCode("200");
            }
            return result;
        }
        // 封装数据
        return JSONUtil.toJsonStr(JSONObject.toJSONString(body));
    }
}
