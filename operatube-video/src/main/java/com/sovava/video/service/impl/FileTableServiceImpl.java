package com.sovava.video.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sovava.video.entity.FileTable;
import com.sovava.video.service.FileTableService;
import com.sovava.video.dao.FileTableMapper;
import org.springframework.stereotype.Service;

/**
* @author root
* @description 针对表【file_table(文件表)】的数据库操作Service实现
* @createDate 2023-01-13 22:17:14
*/
@Service
public class FileTableServiceImpl extends ServiceImpl<FileTableMapper, FileTable>
    implements FileTableService{

}




