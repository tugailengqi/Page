package com.lq.page.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lq.page.domain.entity.*;
import com.lq.page.domain.vo.ApplyVo;
import com.lq.page.mapper.*;
import com.lq.page.service.ApplyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("/applyService")
public class ApplyServiceImpl implements ApplyService {
    @Resource
    ApplyMapper applyMapper;
    @Override
    public int insertApply(int uId, String pId,Integer mId) {
        return applyMapper.insertApply(uId, pId,mId);
    }

    @Override
    public List<Apply> findApplyByUid(int uId) {
        return applyMapper.findByUid(uId);
    }

    @Override
    public int deleteApply(int uId, String pId) {
        return applyMapper.deleteApply(uId, pId);
    }

    @Override
    public PageInfo<ApplyVo> findByMid(Integer mId,Integer access,Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<ApplyVo> list = applyMapper.findByMid(mId,access);
        PageInfo<ApplyVo> pageInfo = new PageInfo<>(list);
        pageInfo.setTotal((long) list.size());
        return pageInfo;
    }

    @Override
    public PageInfo<ApplyVo> findByWorks(String[] works,String[] education,Integer access,Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<ApplyVo> list = applyMapper.findByWorkExperience(works,education,access);
        PageInfo<ApplyVo> pageInfo = new PageInfo<>(list);
        pageInfo.setTotal((long) list.size());
        return pageInfo;
    }

    @Override
    public int updateAccess(Integer access, Integer[] uid) {
        return applyMapper.updateAccess(access, uid);
    }
}
