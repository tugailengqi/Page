package com.lq.page.controller;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageInfo;
import com.lq.page.domain.entity.User;
import com.lq.page.domain.vo.UserVo;
import com.lq.page.service.UserService;
import com.lq.page.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping("/login")
    public Result login(String username,String password){
        try {
            User name = userService.findByName(username);
            if (name == null){
                return Result.error();
            }else {
                if (name.getPassword().equals(password)){
                    return Result.success(name);
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
    @RequestMapping("/register")
    public Result register(User user){
        try {
            int rows = userService.addUser(user);
            return Result.success(rows);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
    @RequestMapping("/findById")
    public Result findById(int uId){
        try {
            if (uId<=0){
                return Result.error();
            }
            UserVo user = userService.findById(uId);
            return Result.success(user);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
    @RequestMapping("/queryByName")
    public Result queryByName(String username){
        try {
            if (!StringUtils.isEmpty(username)){
                User name = userService.findByName(username);
                if (name.getUsername().equals(username)){
                    return Result.success(name);
                }
                return Result.error();
            }
            return Result.error();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
    @GetMapping("/countUser")
    public Result countUser(){
        try {
            int row = userService.countUser();
            return Result.success(row);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
    @GetMapping("/queryAll")
    public Result queryAll(@RequestParam(defaultValue = "1") Integer currentPage, @RequestParam(defaultValue = "10") Integer pageSize){
        try {
            PageInfo<User> all = userService.queryAll(currentPage, pageSize);
            return Result.success(all);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.error();
        }
    }
}
