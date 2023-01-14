package com.sovava.common.to;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 收藏夹
 * @TableName favorites_table
 */
@Data
public class FavoritesTableTo implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private Long articeId;

    /**
     * 
     */
    private Long userId;

    /**
     * 
     */
    private Long createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}