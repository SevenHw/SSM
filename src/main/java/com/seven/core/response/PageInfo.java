package com.seven.core.response;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 分页查询条件
 */
@Data
@ApiModel(value = "分页查询条件", description = "分页查询条件")
public class PageInfo<T> {

    private static final long serialVersionUID = -3670340890587838413L;

    /**
     * 页码
     */
    @ApiModelProperty(value = "页码",required = true, example = "1")
    private Integer pageNum;

    /**
     * 每页条数
     */
    @ApiModelProperty(value = "每页条数",required = true, example = "5")
    private Integer pageSize;

    /**
     * 总数
     */
    @ApiModelProperty("总数")
    private Integer total;

    /**
     * 数据集合
     */
    @ApiModelProperty("数据集合")
    public List<T> list;

    /**
     * - 查询条件
     */
    @ApiModelProperty(value = "查询条件")
    private String filter;

    public PageInfo() {
    }


    public PageInfo pag(List<T> list) {
        PageInfo<Object> pageInfo = new PageInfo<>();
        total = list==null?0:list.size();
        if (list!=null && list.size()!=0) {
            this.list = list.stream()
                    .skip((this.pageNum - 1) * this.pageSize)
                    .limit(this.pageSize)
                    .collect(Collectors.toList());
        }
        pageInfo.setTotal(this.total);
        pageInfo.setPageNum(this.pageNum);
        pageInfo.setPageSize(this.pageSize);
        pageInfo.setList(Collections.singletonList(this.list));
        return pageInfo;
    }

    public Map<String ,Object> getMap(){
        if (filter==null||"".equals(filter)) {
            return new HashMap(16);
        }
        return JSONObject.parseObject(filter, Map.class);
    }
}
