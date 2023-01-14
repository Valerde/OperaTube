package com.sovava.video.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName comment
 */
@TableName(value ="comment")
@Data
public class Comment implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private Long articleId;

    /**
     * 
     */
    private Long userId;

    /**
     * 评论
     */
    private String comment;

    /**
     * 父级评论
     */
    private Long commentId;

    /**
     * 父级评论
     */
    private Long parentCommentId;

    /**
     * 评论对象
     */
    private Long parentUserId;

    /**
     * 喜欢数
     */
    private Long likeCount;

    /**
     * 评论数
     */
    private Long commentCount;

    /**
     * 不喜欢
     */
    private Long dislikeCount;

    /**
     * 【1 一级评论  2 二级评论】
     */
    private Integer type;

    /**
     * [0 正常  1 删除]
     */
    private Integer status;

    /**
     * 
     */
    private Long createTime;

    /**
     * 
     */
    private Long updateTime;

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