package com.caiyide.primary.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.caiyide.primary.common.entity.BaseEntity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * <p>
 * 广告
 * </p>
 *
 * @author liusiyu
 * @date 2018-12-28
 */
@TableName("b_advertisement")
@ApiModel("广告")
public class BAdvertisement extends BaseEntity {

    /**
     * 广告ID
     */
	@ApiModelProperty("广告ID")
	@TableId(value="Advert_id", type= IdType.AUTO)
	private Integer AdvertId;
    /**
     * 图片
     */
	@ApiModelProperty("图片")
	@TableField("Advert_image")
	private String AdvertImage;
    /**
     * 1-头部背景图 2-轮播图
     */
	@ApiModelProperty("1-头部背景图 2-轮播图")
	@TableField("Advert_type")
	private Integer AdvertType;
    /**
     * 创建时间
     */
	@ApiModelProperty("创建时间")
	@TableField("create_time")
	private Date createTime;


	public Integer getAdvertId() {
		return AdvertId;
	}

	public void setAdvertId(Integer AdvertId) {
		this.AdvertId = AdvertId;
	}

	public String getAdvertImage() {
		return AdvertImage;
	}

	public void setAdvertImage(String AdvertImage) {
		this.AdvertImage = AdvertImage;
	}

	public Integer getAdvertType() {
		return AdvertType;
	}

	public void setAdvertType(Integer AdvertType) {
		this.AdvertType = AdvertType;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	@Override
	protected Serializable pkVal() {
        return this.AdvertId;
	}

	@Override
	public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
