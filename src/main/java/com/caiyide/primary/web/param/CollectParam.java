package com.caiyide.primary.web.param;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @outhor liusiyu
 * @create 2019-02-21-15:41
 */
public class CollectParam {
    /**
     * 收藏id
     */
    @ApiModelProperty("收藏id")
    @TableId(value="collect_id", type= IdType.AUTO)
    private Integer collectId;
    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    @TableField("user_id")
    private String userId;
    /**
     * 商家ID
     */
    @ApiModelProperty("商家ID")
    @TableField("shop_id")
    private String shopId;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createtime;

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public Integer getCollectId() {
        return collectId;
    }

    public void setCollectId(Integer collectId) {
        this.collectId = collectId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
