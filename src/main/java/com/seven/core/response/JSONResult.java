package com.seven.core.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * JSON返回结果
 *
 * @param <T>
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "接口返回对象", description = "接口返回对象")
public class JSONResult<T> implements Serializable {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    public JSONResult() {
        this.timestamp = System.currentTimeMillis();
    }

    public JSONResult(T t) {
        this.timestamp = System.currentTimeMillis();
        result = t;
    }

    /**
     * -- 编码
     */
    @ApiModelProperty("返回代码")
    private String code;

    /**
     * -- 消息
     */
    @ApiModelProperty("返回消息")
    private String message;

    /**
     * --是否成功
     * -- true: 成功
     * -- false: 失败
     */
    @ApiModelProperty("成功标识")
    private boolean success;

    /**
     * -- 执行结果
     */
    @ApiModelProperty("返回结果")
    private T result;

    /**
     * -- 时间戳
     */
    @ApiModelProperty("执行时间")
    private long timestamp;

}
