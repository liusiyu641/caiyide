package com.caiyide.primary.common.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.plugins.Page;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * @author liujixiang
 * @date 2018/8/7
 */
@ApiModel("分页")
public class Paging<T> implements Serializable {
    private static final long serialVersionUID = -1683800405530086022L;

    @ApiModelProperty("总行数")
    @JSONField(name = "list")
    @JsonProperty("list")
    private Integer total = 0;

    @ApiModelProperty("数据列表")
    @JSONField(name = "items")
    @JsonProperty("items")
    private List<T> records = Collections.emptyList();

    public Paging() {
    }

    public Paging(Page page) {
        this.total = page.getTotal();
        this.records = page.getRecords();
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    @Override
    public String toString() {
        return "Paging{" +
                "total=" + total +
                ", records=" + records +
                '}';
    }
}
