package com.lq.page.service.impl;

import com.lq.page.domain.entity.Progress;
import com.lq.page.mapper.ProgressMapper;
import com.lq.page.service.ProgressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProgressServiceImpl implements ProgressService {
    @Resource
    ProgressMapper progressMapper;
    @Override
    public Progress queryById(Integer mid) {
        return progressMapper.queryByMid(mid);
    }

    @Override
    public int insert(Progress progress) {
        return progressMapper.insert(progress);
    }
}
