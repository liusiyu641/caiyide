package com.caiyide.primary.common.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.caiyide.primary.common.constant.ResponseCode;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 响应结果
 * @author liujixiang
 * @date 2018/08/05
 */
@ApiModel("响应结果对象")
public class ResponseResult implements Serializable {
    private static final long serialVersionUID = -26086773651590416L;
    @ApiModelProperty("响应码")
    private Integer code = ResponseCode.SUCCESS;
    @ApiModelProperty("响应消息")
    private String msg;
    @ApiModelProperty("响应数据")
    private Object data;
    @ApiModelProperty("响应时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time = new Date();

    public ResponseResult() {
    }

    public ResponseResult(String msg) {
        this.msg = msg;
    }

    public ResponseResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public  ResponseResult(Object data) {
        this.data = data;
    }

    public ResponseResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseResult(Integer code, String msg, Object data, Date time) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.time = time;
    }

    public static ResponseResult success(String message){
        return new ResponseResult(ResponseCode.SUCCESS,message);
    }

    public static ResponseResult error(String message){
        return new ResponseResult(ResponseCode.ERROR,message);
    }

    public static ResponseResult handle(boolean flag){
        if (flag){
            return success("操作成功");
        }else{
            return error("操作失败");
        }
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", time=" + time +
                '}';
    }
}
