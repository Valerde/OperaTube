package com.sovava.video.dao;

import com.sovava.video.entity.FileTable;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author root
* @description 针对表【file_table(文件表)】的数据库操作Mapper
* @createDate 2023-01-13 22:17:14
* @Entity com.sovava.video.entity.FileTable
*/
@Mapper
public interface FileTableMapper extends BaseMapper<FileTable> {

}




