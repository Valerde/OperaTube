package com.sovava.common.to;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName category
 */
@Data
public class CategoryTo implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 分区名
     */
    private String name;

    /**
     * 分区级别【1 一级分区， 2 二级分区】
     */
    private Integer type;

    /**
     * 父级分区
     */
    private Integer fatherId;

    /**
     * 介绍
     */
    private String describes;

    /**
     * 图标
     */
    private String icon;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 
     */
    private Long createTime;

    /**
     * 
     */
    private Long updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}