package com.lq.page.service;

import com.github.pagehelper.PageInfo;
import com.lq.page.domain.vo.ResumeAndPosition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PendingService {
    int addPend(Integer uInfoId,Integer flag,Integer mid);
    PageInfo<ResumeAndPosition> queryByFlag(Integer flag,Integer mid,Integer currentPage, Integer pageSize);
    PageInfo<ResumeAndPosition> queryByWorkExperience(String[] works,String[] education,Integer flag,Integer mid,Integer currentPage, Integer pageSize);
    int deletePend(Integer uInfoId);
}
