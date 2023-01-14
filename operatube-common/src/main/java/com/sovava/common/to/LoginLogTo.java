package com.sovava.common.to;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName login_log
 */
@Data
public class LoginLogTo implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 登录时间
     */
    private Long loginTime;

    /**
     * 登录IP
     */
    private String ip;

    /**
     * 浏览器UA
     */
    private String ua;

    /**
     * 登录用户ID
     */
    private Long userid;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}