package com.lq.page.controller;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageInfo;
import com.lq.page.domain.entity.UserInfo;
import com.lq.page.domain.vo.ApplyVo;
import com.lq.page.domain.vo.ResumeAndPosition;
import com.lq.page.service.UserInfoService;
import com.lq.page.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @Resource
    UserInfoService userInfoService;

    @RequestMapping("/addUserInfo")
    public Result addUserInfo(UserInfo userInfo){
        try {
            int rows = userInfoService.insertUserInfo(userInfo);
            return Result.success(rows);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }

    @RequestMapping("/findByUserId")
    public Result findByUserId(int uId){
        try {
            if (uId<=0){
                return Result.error();
            }
            ResumeAndPosition position = userInfoService.findById(uId);
            return Result.success(position);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
    @PostMapping("/updateUserInfo")
    public Result updateUserInfo(UserInfo userInfo){
        try {
            int row = userInfoService.updateInfo(userInfo);
            return Result.success(row);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
    @GetMapping("/findAll")
    public Result findAll(@RequestParam(defaultValue = "1") Integer currentPage, @RequestParam(defaultValue = "10") Integer pageSize){
        try {
            PageInfo<ResumeAndPosition> all = userInfoService.queryAll(currentPage, pageSize);
            return Result.success(all);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
    @GetMapping("/queryByWorkExperience")
    public Result queryByWorkExperience(String[] workExperience,String[] education,@RequestParam(defaultValue = "1") Integer currentPage, @RequestParam(defaultValue = "10") Integer pageSize){
        try {
            if (workExperience.length == 0 || education.length ==0){
                return Result.error();
            }
            PageInfo<ResumeAndPosition> experience = userInfoService.queryByWorkExperience(workExperience, education, currentPage, pageSize);
            return Result.success(experience);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
}
