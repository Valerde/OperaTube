package com.sovava.video.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sovava.common.utils.PageUtils;
import com.sovava.common.utils.Query;
import com.sovava.video.entity.Comment;
import com.sovava.video.entity.PlayRecording;
import com.sovava.video.service.PlayRecordingService;
import com.sovava.video.dao.PlayRecordingMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
* @author root
* @description 针对表【play_recording(播放记录)】的数据库操作Service实现
* @createDate 2023-01-13 22:17:14
*/
@Service
public class PlayRecordingServiceImpl extends ServiceImpl<PlayRecordingMapper, PlayRecording>
    implements PlayRecordingService{
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PlayRecording> page = this.page(
                new Query<PlayRecording>().getPage(params),
                new QueryWrapper<PlayRecording>()
        );

        return new PageUtils(page);

    }
}




