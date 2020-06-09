package com.lq.page.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lq.page.domain.entity.Member;
import com.lq.page.mapper.MemberMapper;
import com.lq.page.service.MemberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    @Resource
    MemberMapper memberMapper;

    @Override
    public int countMember() {
        return memberMapper.countMember();
    }

    @Override
    public PageInfo<Member> queryAll(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Member> all = memberMapper.findAll();
        return new PageInfo<>(all);
    }

    @Override
    public Member queryByEmail(String mEmail) {
        return memberMapper.findByEmail(mEmail);
    }

    @Override
    public int insertMember(Member member) {
        return memberMapper.addMember(member);
    }

//    @Override
//    public Member queryByEmail(String mEmail) {
//        return memberMapper.findByEmail(mEmail);
//    }
}
