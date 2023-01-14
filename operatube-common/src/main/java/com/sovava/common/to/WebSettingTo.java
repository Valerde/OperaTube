package com.sovava.common.to;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName web_setting
 */
@Data
public class WebSettingTo implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 网站名
     */
    private String name;

    /**
     * 是否开启非vip每日观看次数限制 [0 关闭， 1 开启]
     */
    private Integer openNoVipLimit;

    /**
     * 非vip 每日观看次数
     */
    private Integer noVipViewCount;

    /**
     * 网页logo地址
     */
    private String logoUrl;

    /**
     * 是否开启邀请码注册 【0 关闭， 1开启】
     */
    private Integer openInvitationRegister;

    /**
     * 网页简短的描述
     */
    private String webdescribe;

    /**
     * 是否开启每日上传视频增加非会员观看次数 【0 关闭， 1开启】
     */
    private Integer openUploadVideoAddViewCount;

    /**
     * 是否开启视频，文章，图片审核 【0 关闭， 1 开启】
     */
    private Integer openExamine;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 首页最大显示数
     */
    private Integer homeMaxVideoCount;

    private static final long serialVersionUID = 1L;

}