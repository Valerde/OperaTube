package com.sovava.video.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 通知表
 * @TableName notification
 */
@TableName(value ="notification")
@Data
public class Notification implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 通知发送人ID
     */
    private Long notifier;

    /**
     * 通知接收人ID
     */
    private Long receiver;

    /**
     * 外部ID，如主帖子ID
     */
    private Long outerId;

    /**
     * 评论内容
     */
    private String commentContent;

    /**
     * 评论目标ID
     */
    private Long commentId;

    /**
     * 类型 【0 回复帖子， 1 回复评论，2 收到点赞  3 系统通知】
     */
    private Integer type;

    /**
     * 
     */
    private Long createTime;

    /**
     * 【0 未读， 1 已读】
     */
    private Integer status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}