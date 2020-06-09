package com.lq.page.mapper;


import com.alibaba.druid.util.StringUtils;
import com.lq.page.domain.entity.Member;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface MemberMapper {
    List<Member> findAll();
    int countMember();
    Member findByEmail(@Param("mEmail") String mEmail);
    int addMember(@Param("member") Member member);
//    Member findByEmail(@Param("mEmail")String mEmail);
}