package com.sovava.video.service;

import com.sovava.common.utils.PageUtils;
import com.sovava.video.entity.FileTable;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
* @author root
* @description 针对表【file_table(文件表)】的数据库操作Service
* @createDate 2023-01-13 22:17:14
*/
public interface FileTableService extends IService<FileTable> {
    PageUtils queryPage(Map<String, Object> params);
}
