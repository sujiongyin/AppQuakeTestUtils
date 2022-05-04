package com.ooooo.quake.dto;

import com.github.pagehelper.PageInfo;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PageParam {
    private Integer page;
    private Integer size;
    private Long total;
    private Object  list;

    public PageParam getReuslt(PageInfo pageInfo){
       this.total=pageInfo.getTotal();
       this.list =pageInfo.getList();
       return this;
    }
}
