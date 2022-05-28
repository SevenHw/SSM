package com.seven.matlab.service;


import com.seven.core.response.PageInfo;
import com.seven.pojo.dto.UserDto;

import java.util.Map;

public interface UserService {
    void save(UserDto dto)throws Exception;

    void delete(String id) throws Exception;

    void update(UserDto dto)throws Exception;

    PageInfo query(PageInfo pageInfo)throws Exception;
}
