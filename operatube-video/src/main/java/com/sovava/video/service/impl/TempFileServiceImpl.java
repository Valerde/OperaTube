package com.sovava.video.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sovava.common.utils.PageUtils;
import com.sovava.common.utils.Query;
import com.sovava.video.entity.Comment;
import com.sovava.video.entity.TempFile;
import com.sovava.video.service.TempFileService;
import com.sovava.video.dao.TempFileMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
* @author root
* @description 针对表【temp_file】的数据库操作Service实现
* @createDate 2023-01-13 22:17:14
*/
@Service
public class TempFileServiceImpl extends ServiceImpl<TempFileMapper, TempFile>
    implements TempFileService{
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TempFile> page = this.page(
                new Query<TempFile>().getPage(params),
                new QueryWrapper<TempFile>()
        );

        return new PageUtils(page);

    }
}




