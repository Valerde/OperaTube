package com.sovava.common.to;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName invitation_code
 */
@Data
public class InvitationCodeTo implements Serializable {
    /**
     * 
     */
    private Long id;

    /**
     * 邀请码
     */
    private String code;

    /**
     * 生成邀请码的人
     */
    private Long createUser;

    /**
     * 使用邀请吗的人
     */
    private Long useUser;

    /**
     * 【1 未被使用， 0 已经被使用】
     */
    private Integer useStatus;

    /**
     * 生成时间
     */
    private Long createTime;

    /**
     * 使用时间
     */
    private Long useTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}