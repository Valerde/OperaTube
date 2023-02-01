package com.sovava.video.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sovava.common.utils.PageUtils;
import com.sovava.common.utils.Query;
import com.sovava.video.entity.Comment;
import com.sovava.video.entity.FileTable;
import com.sovava.video.service.FileTableService;
import com.sovava.video.dao.FileTableMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
* @author root
* @description 针对表【file_table(文件表)】的数据库操作Service实现
* @createDate 2023-01-13 22:17:14
*/
@Service
public class FileTableServiceImpl extends ServiceImpl<FileTableMapper, FileTable>
    implements FileTableService{
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FileTable> page = this.page(
                new Query<FileTable>().getPage(params),
                new QueryWrapper<FileTable>()
        );

        return new PageUtils(page);

    }
}




