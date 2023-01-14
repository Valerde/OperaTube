package com.sovava.video.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 点赞
 * @TableName like_table
 */
@TableName(value ="like_table")
@Data
public class LikeTable implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 喜欢的对象ID
     */
    private Long likeObjId;

    /**
     * 
     */
    private Long userId;

    /**
     * 
     */
    private Long createTime;

    /**
     * 【0 视频图片文章主帖子  1 评论】
     */
    private Integer type;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}