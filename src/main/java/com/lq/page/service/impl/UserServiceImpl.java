package com.lq.page.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lq.page.domain.entity.User;
import com.lq.page.domain.vo.UserVo;
import com.lq.page.mapper.UserMapper;
import com.lq.page.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("/userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int countUser() {
        return userMapper.countUser();
    }

    @Override
    public PageInfo<User> queryAll(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<User> all = userMapper.findAll();
        return new PageInfo<>(all);
    }

    @Override
    public User findByName(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public UserVo findById(int uId) {
        return userMapper.findById(uId);
    }
}
