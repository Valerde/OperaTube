package com.sovava.common.to;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName user_role
 */
@Data
public class UserRoleTo implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private Long userid;

    /**
     * 角色
     */
    private String role;

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
    private Long vipStartTime;

    /**
     * 
     */
    private Long vipStopTime;

    /**
     * 修改人
     */
    private Long modified;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}