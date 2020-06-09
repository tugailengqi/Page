package com.lq.page.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lq.page.domain.entity.*;
import com.lq.page.domain.vo.ResumeAndPosition;
import com.lq.page.mapper.*;
import com.lq.page.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("/userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    UserInfoMapper userInfoMapper;
    @Override
    public int insertUserInfo(UserInfo userInfo) {
        return userInfoMapper.addUserInfo(userInfo);
    }

    @Override
    public ResumeAndPosition findById(int uId) {
        return userInfoMapper.findById(uId);
    }

    @Override
    public int updateInfo(UserInfo userInfo) {
        return userInfoMapper.updateUserInfo(userInfo);
    }

    @Override
    public PageInfo<ResumeAndPosition> queryAll(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<ResumeAndPosition> all = userInfoMapper.findAll();
        return new PageInfo<>(all);
    }

    @Override
    public PageInfo<ResumeAndPosition> queryByWorkExperience(String[] works, String[] education, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<ResumeAndPosition> list = userInfoMapper.findByWorkExperience(works, education);
        return new PageInfo<>(list);
    }
}
