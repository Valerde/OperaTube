package com.sovava.video.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName temp_file
 */
@TableName(value ="temp_file")
@Data
public class TempFile implements Serializable {
    /**
     * 
     */
    @TableId
    private Long id;

    /**
     * 
     */
    private Long createTime;

    /**
     * 
     */
    private String date;

    /**
     * 
     */
    private String filename;

    /**
     * 
     */
    private String path;

    /**
     * 
     */
    private Long size;

    /**
     * 
     */
    private String uploadFilename;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}