package com.lq.page.mapper;

import com.lq.page.domain.entity.Admin;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}