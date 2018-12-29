package com.caiyide.primary.common.vo;

import com.baomidou.mybatisplus.plugins.Page;
import com.caiyide.primary.common.constant.CommonConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * 查询参数
 * @author liujixiang
 */
@ApiModel
public class QueryParam implements Serializable{
	private static final long serialVersionUID = 7305222607977143006L;
	@ApiModelProperty(value = "页码,默认为1")
	private Integer current = CommonConstant.DEFAULT_PAGE_INDEX;
	@ApiModelProperty(value = "页大小,默认为10")
	private Integer size = CommonConstant.DEFAULT_PAGE_SIZE;
	@ApiModelProperty(value = "排序列名称")
	private String orderByField;
	@ApiModelProperty(value = "排序方式,true:asc/false:desc")
	private boolean isAsc;
    @ApiModelProperty(value = "搜索字符串")
    private String keyword;

	public QueryParam() {

    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
	    if (current == null || current == 0){
	        this.current = CommonConstant.DEFAULT_PAGE_INDEX;
        }else{
            this.current = current;
        }
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
	    if (size == null || size == 0){
	        this.size = CommonConstant.DEFAULT_PAGE_SIZE;
        }else{
            this.size = size;
        }
    }

    public String getOrderByField() {
        return orderByField;
    }

    public void setOrderByField(String orderByField) {
        this.orderByField = orderByField;
    }

    public boolean isAsc() {
        return isAsc;
    }

    public void setAsc(boolean asc) {
        isAsc = asc;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void convert(Page page){
        page.setCurrent(this.getCurrent());
        page.setSize(this.getSize());
        page.setOrderByField(this.getOrderByField());
        page.setAsc(this.isAsc());
    }

    public void setDefaultOrder(String orderByField,boolean isAsc){
	    if (StringUtils.isBlank(orderByField)){
	        return;
        }
        if (StringUtils.isBlank(this.orderByField) || "string".equals(this.orderByField)){
            this.orderByField = orderByField;
            this.isAsc = isAsc;
        }


    }

    @Override
    public String toString() {
        return "QueryParam{" +
                "current=" + current +
                ", size=" + size +
                ", orderByField='" + orderByField + '\'' +
                ", isAsc=" + isAsc +
                ", keyword='" + keyword + '\'' +
                '}';
    }
}
