package com.lq.page.service;

import com.github.pagehelper.PageInfo;
import com.lq.page.domain.entity.Apply;
import com.lq.page.domain.entity.CollectionBean;
import com.lq.page.domain.vo.ApplyVo;
import com.lq.page.domain.vo.ResumeAndPosition;

import java.util.List;

public interface ApplyService {
    /**
     * 插入
     * @param uId 用户id
     * @param pId 职位id
     * @return 返回整数
     */
    int insertApply(int uId,String pId,Integer mId);
    List<Apply> findApplyByUid(int uId);
    int deleteApply(int uId,String pId);
    PageInfo<ApplyVo> findByMid(Integer mId,Integer access,Integer currentPage, Integer pageSize);
    PageInfo<ApplyVo> findByWorks(String[] works,String[] education,Integer access,Integer currentPage, Integer pageSize);
    int updateAccess(Integer access,Integer[] uid);
}
