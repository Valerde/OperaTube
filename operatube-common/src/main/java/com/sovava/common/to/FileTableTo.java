package com.sovava.common.to;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 文件表
 * @TableName file_table
 */
@Data
public class FileTableTo implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 视频，图片，文章ID， 需要后期更新，没有此项的文件后期需要清楚
     */
    private Long articleId;

    /**
     * 服务器保存的文件地址
     */
    private String fileUrl;

    /**
     * 文件原始名
     */
    private String fileOriginalName;

    /**
     * 新的文件名
     */
    private String fileNewName;

    /**
     * 文件大小
     */
    private Long size;

    /**
     * 上传时间
     */
    private Long uploadTime;

    /**
     * 上传人
     */
    private Long uploadUserId;

    /**
     * 文件类型 【0 视频， 1 图片， 2 其它附件, 3 头像数据， 4 顶部大图数据】
     */
    private Integer type;

    /**
     * 后缀名
     */
    private String suffixName;

    /**
     * 视频长度
     */
    private Double duration;

    /**
     * 文件存储状态   0  未保存的临时文件，后期删除   1  保存成功并发布的文件
     */
    private Integer status;

    /**
     * 视频高度
     */
    private Integer height;

    /**
     * 视频宽度
     */
    private Integer width;

    /**
     * 像素数
     */
    private Long pixelsNumber;

    /**
     * 帧率
     */
    private Double frameRate;

    /**
     * 其他信息
     */
    private String info;

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