package com.lq.page.service;


import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageInfo;
import com.lq.page.domain.entity.Member;

import java.util.List;

public interface MemberService {
    int countMember();
    PageInfo<Member> queryAll(Integer currentPage, Integer pageSize);
    Member queryByEmail(String mEmail);
    int insertMember(Member member);
//    Member queryByEmail(String mEmail);
}
