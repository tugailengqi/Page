package com.lq.page.service;

import com.github.pagehelper.PageInfo;
import com.lq.page.domain.entity.UserInfo;
import com.lq.page.domain.vo.ResumeAndPosition;

import java.util.List;

public interface UserInfoService {
    int insertUserInfo(UserInfo userInfo);
    ResumeAndPosition findById(int uId);
    int updateInfo(UserInfo userInfo);
    PageInfo<ResumeAndPosition> queryAll(Integer currentPage, Integer pageSize );
    PageInfo<ResumeAndPosition> queryByWorkExperience(String[] works,String[] education,Integer currentPage, Integer pageSize);

}
