package com.lq.page.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lq.page.domain.vo.ResumeAndPosition;
import com.lq.page.mapper.PendingMapper;
import com.lq.page.service.PendingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PendingServiceImpl implements PendingService {
    @Resource
    PendingMapper pendingMapper;
    @Override
    public int addPend(Integer uInfoId, Integer flag,Integer mid) {
        return pendingMapper.insert(uInfoId, flag,mid);
    }

    @Override
    public PageInfo<ResumeAndPosition> queryByFlag(Integer flag,Integer mid,Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<ResumeAndPosition> list = pendingMapper.findByFlag(flag,mid);
        return new PageInfo<>(list);
    }

    @Override
    public PageInfo<ResumeAndPosition> queryByWorkExperience(String[] works, String[] education,Integer flag,Integer mid, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<ResumeAndPosition> positionList = pendingMapper.findByWorkExperience(works, education,flag,mid);
        return new PageInfo<>(positionList);
    }

    @Override
    public int deletePend(Integer uInfoId) {
        return pendingMapper.delete(uInfoId);
    }
}
