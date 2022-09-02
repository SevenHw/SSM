package com.seven.matlab.controller;

import com.seven.core.response.JSONResult;
import com.seven.core.response.PageInfo;
import com.seven.matlab.service.UserService;
import com.seven.pojo.dto.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api(tags = "用户信息")
@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService service;

    @ApiOperation(value = "添加")
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public JSONResult save(@RequestBody UserDto dto) throws Exception {
        try {
            service.save(dto);
            return new JSONResult().setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONResult().setSuccess(true);
        }
    }

    @ApiOperation(value = "删除")
    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    public JSONResult delete(@PathVariable(value = "id") String id) throws Exception {
        try {
            service.delete(id);
            return new JSONResult().setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONResult().setSuccess(true);
        }
    }

    @ApiOperation(value = "修改")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public JSONResult update(@RequestBody UserDto dto) throws Exception {
        try {
            service.update(dto);
            return new JSONResult().setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONResult().setSuccess(true);
        }
    }

    @ApiOperation(value = "查询")
    @RequestMapping(value = "query", method = RequestMethod.POST)
    public JSONResult query(PageInfo pageInfo) throws Exception {
        try {
            PageInfo info = service.query(pageInfo);
            return new JSONResult().setSuccess(true).setResult(info);
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONResult().setSuccess(true);
        }
    }
}
