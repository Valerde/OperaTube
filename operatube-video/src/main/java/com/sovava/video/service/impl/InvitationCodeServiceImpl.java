package com.sovava.video.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sovava.common.utils.PageUtils;
import com.sovava.common.utils.Query;
import com.sovava.video.entity.Comment;
import com.sovava.video.entity.InvitationCode;
import com.sovava.video.service.InvitationCodeService;
import com.sovava.video.dao.InvitationCodeMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
* @author root
* @description 针对表【invitation_code】的数据库操作Service实现
* @createDate 2023-01-13 22:17:14
*/
@Service
public class InvitationCodeServiceImpl extends ServiceImpl<InvitationCodeMapper, InvitationCode>
    implements InvitationCodeService{
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<InvitationCode> page = this.page(
                new Query<InvitationCode>().getPage(params),
                new QueryWrapper<InvitationCode>()
        );

        return new PageUtils(page);

    }
}




