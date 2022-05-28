package com.seven.core.response.enums;

/**
 * 错误编码
 */
public enum ResultCode {
    SUCCESS("200", "操作成功"),
    UNKNOWN_ERROR("-1", "未知错误"),
    BAD_REQUEST("400", "不合法的请求"),
    UNAUTHORIZED("401", "权限不足"),
    RESOURCE_NOT_FOUND("404", "资源未找到"),
    SERVER_INTERNAL_ERROR("500", "服务内部错误"),
    NO_LOGIN("501", "未登录"),
    BAD_ARGUMENT("601", "参数错误"),
    BAD_ARGUMENT_VALUE("602", "参数值错误"),
    OBJECT_NULL("603", "未获取到对象信息"),
    ;

    private String code;

    private String message;

    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
