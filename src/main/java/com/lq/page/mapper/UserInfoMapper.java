package com.lq.page.mapper;

import com.lq.page.domain.entity.UserInfo;
import com.lq.page.domain.vo.ResumeAndPosition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface    UserInfoMapper {
    int addUserInfo(@Param("userInfo") UserInfo userInfo);
    ResumeAndPosition findById(@Param("uId")int uId);
    int updateUserInfo(@Param("userInfo") UserInfo userInfo);
    List<ResumeAndPosition> findByWorkExperience(@Param("works") String[] works,@Param("educations")String[] educations);
    List<ResumeAndPosition> findAll();
}