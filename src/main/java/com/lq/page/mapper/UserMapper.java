package com.lq.page.mapper;

import com.lq.page.domain.entity.User;
import com.lq.page.domain.vo.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<User> findAll();
    int countUser();
    User findByUsername(@Param("username")String username);
    int addUser(@Param("user")User user);
    UserVo findById(@Param("uId")int uId);
}