package com.seven.matlab.dao;

import com.seven.pojo.dto.UserDto;
import com.seven.pojo.vo.UserVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserDao {
    void insert(UserDto dto)throws Exception;

    void delete(@Param(value = "id") String id)throws Exception;

    void update(UserDto dto)throws Exception;

    List<UserVo> select(Map map)throws Exception;
}
