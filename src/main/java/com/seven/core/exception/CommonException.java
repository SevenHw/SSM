package com.seven.core.exception;

import com.seven.core.response.enums.ResultCode;
import lombok.Data;

/**
 * 自定义异常
 */
@Data
public class CommonException extends RuntimeException {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 6592747653657352571L;

    /**
     * 编码
     */
    private String code;

    /**
     * 消息
     */
    private String message;

    /**
     * 构造函数
     */
    public CommonException() {
    }

    public CommonException(String message) {
        this.message = message;
    }

    public CommonException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public CommonException(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public CommonException(ResultCode resultCode, String message) {
        this.code = resultCode.getCode();
        this.message = message;
    }
}
