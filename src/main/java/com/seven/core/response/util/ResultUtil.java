package com.seven.core.response.util;

import cn.hutool.core.util.ObjectUtil;
import com.seven.core.response.JSONResult;
import com.seven.core.response.enums.ResultCode;

/**
 * 返回结果工具
 */
public class ResultUtil {

    /**
     * 成功且带返回数据
     *
     * @param t
     * @return
     */
    public static <T> JSONResult<T> success(T t) {
        JSONResult result = new JSONResult();
        result.setSuccess(true);
        result.setCode(ResultCode.SUCCESS.getCode().toString());
        result.setMessage(ResultCode.SUCCESS.getMessage());
        if (!ObjectUtil.isEmpty(t)) {
            result.setResult(t);
        }
        return result;
    }

    /**
     * 成功无返回数据
     *
     * @return
     */
    public static JSONResult success() {
        return success(null);
    }

    /**
     * 错误
     *
     * @param message
     * @return
     */
    public static JSONResult error(String message) {
        JSONResult result = new JSONResult();
        result.setSuccess(false);
        result.setCode(ResultCode.SERVER_INTERNAL_ERROR.getCode().toString());
        result.setMessage(message);
        return result;
    }

    /**
     * 错误
     *
     * @param code
     * @param message
     * @return
     */
    public static JSONResult error(String code, String message) {
        JSONResult result = new JSONResult();
        result.setSuccess(false);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    /**
     * 错误
     *
     * @param resultCode
     * @return
     */
    public static JSONResult error(ResultCode resultCode) {
        JSONResult result = new JSONResult();
        result.setSuccess(false);
        result.setCode(resultCode.getCode().toString());
        result.setMessage(resultCode.getMessage());
        return result;
    }

    /**
     * 错误
     *
     * @param resultCode
     * @param message
     * @return
     */
    public static JSONResult error(ResultCode resultCode, String message) {
        JSONResult result = new JSONResult();
        result.setSuccess(false);
        result.setCode(resultCode.getCode().toString());
        result.setMessage(message);
        return result;
    }

    /**
     * 参数错误
     *
     * @return
     */
    public static JSONResult badArgument() {
        return error(ResultCode.BAD_ARGUMENT);
    }

    /**
     * 参数值错误
     *
     * @return
     */
    public static JSONResult badArgumentValue() {
        return error(ResultCode.BAD_ARGUMENT_VALUE);
    }

    /**
     * 未登录
     *
     * @return
     */
    public static JSONResult noLogin() {
        return error(ResultCode.NO_LOGIN);
    }

    /**
     * 未授权
     *
     * @return
     */
    public static JSONResult unauthz() {
        return error(ResultCode.UNAUTHORIZED);
    }

    /**
     * 404
     *
     * @return
     */
    public static JSONResult notfound() {
        return error(ResultCode.RESOURCE_NOT_FOUND);
    }
}
