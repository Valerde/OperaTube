package com.sovava.video.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 弹幕表
 * @TableName danmaku
 */
@TableName(value ="danmaku")
@Data
public class Danmaku implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 视频ID
     */
    private Long videoId;

    /**
     * 弹幕颜色
     */
    private String color;

    /**
     * 弹幕内容
     */
    private String text;

    /**
     * 时间
     */
    private Double time;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 作者
     */
    private Long author;

    /**
     * 十进制颜色数据
     */
    private Long colorDec;

    /**
     * 
     */
    private String ua;

    /**
     * 
     */
    private String ip;

    /**
     * 
     */
    private String city;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}