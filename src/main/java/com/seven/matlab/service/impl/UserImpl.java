package com.seven.matlab.service.impl;

import cn.hutool.core.util.IdUtil;
import com.seven.core.response.PageInfo;
import com.seven.matlab.dao.UserDao;
import com.seven.pojo.dto.UserDto;
import com.seven.matlab.service.UserService;
import com.seven.pojo.vo.UserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @program: SSM
 * @author: Seven
 * @create: 2022-05-17 22:43
 **/
@Service
public class UserImpl implements UserService {
    @Autowired
    private UserDao mapper;

    @Override
    public void save(UserDto dto) throws Exception{
        dto.setId(IdUtil.simpleUUID());
        mapper.insert(dto);
    }

    @Override
    public void delete(String id) throws Exception{
        mapper.delete(id);
    }

    @Override
    public void update(UserDto dto)throws Exception {
        mapper.update(dto);
    }

    @Override
    public PageInfo query(PageInfo pageInfo)throws Exception {
        List<UserVo> vo = mapper.select(pageInfo.getMap());
       return pageInfo.pag(vo);
    }
}
