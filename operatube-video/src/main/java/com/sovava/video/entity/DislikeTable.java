package com.sovava.video.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 点踩
 * @TableName dislike_table
 */
@TableName(value ="dislike_table")
@Data
public class DislikeTable implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private Long dislikeObjId;

    /**
     * 
     */
    private Long userId;

    /**
     * 
     */
    private Long createTime;

    /**
     * 【0 帖子视频图片， 1 评论】
     */
    private Integer type;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}