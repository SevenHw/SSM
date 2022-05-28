package com.seven.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

/**
 * @program: SSM
 * @author: Seven
 * @create: 2022-05-17 22:30
 **/
@Data
public class UserVo implements Serializable {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "名字")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @Override
    public String toString() {
        return "UserVo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserVo userVo = (UserVo) o;
        return Objects.equals(id, userVo.id) && Objects.equals(name, userVo.name) && Objects.equals(age, userVo.age);
    }

}
