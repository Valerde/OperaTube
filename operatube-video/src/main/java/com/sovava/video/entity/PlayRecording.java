package com.sovava.video.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 播放记录
 * @TableName play_recording
 */
@TableName(value ="play_recording")
@Data
public class PlayRecording implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 视频ID
     */
    private Long articleId;

    /**
     * 观看到第几个视频
     */
    private Long fileId;

    /**
     * 时间戳
     */
    private Double videoTime;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 更新时间
     */
    private Long updateTime;

    /**
     * 视频ID
     */
    private Long videoId;

    /**
     * 浏览器ua
     */
    private String ua;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}