package com.caiyide.primary.common.entity;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * @author liujixiang
 * @date 2018/08/05
 */
@ApiModel("BaseEntity")
public abstract class BaseEntity implements Serializable{
    protected abstract Serializable pkVal() ;
}
