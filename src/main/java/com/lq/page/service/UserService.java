package com.lq.page.service;

import com.github.pagehelper.PageInfo;
import com.lq.page.domain.entity.User;
import com.lq.page.domain.vo.UserVo;

import java.util.List;


public interface UserService {
    int countUser();
    PageInfo<User> queryAll(Integer currentPage, Integer pageSize);
    User findByName(String username);
    int addUser(User user);
    UserVo findById(int uId);
}
