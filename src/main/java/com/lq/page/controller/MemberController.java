package com.lq.page.controller;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;

import com.lq.page.domain.entity.Member;
import com.lq.page.domain.entity.User;
import com.lq.page.service.MemberService;
import com.lq.page.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/enterprise")
public class MemberController {
    @Resource
    MemberService memberService;
    @GetMapping("/login")
    public Result login(String mName,String mEmail, String password){
        try {
            Member member = memberService.queryByEmail(mEmail);
            if (!StringUtil.isEmpty(mEmail) && member.getPassword().equals(password) && member.getMName().equals(mName)){
                return Result.success(member);
            }
            return Result.error();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
    @PostMapping("/register")
    public Result register(Member member){
        try {
            int row = memberService.insertMember(member);
            return Result.success(row);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
    @GetMapping("/queryEmail")
    public Result queryEmail(String mEmail){
        try {
            if (!StringUtils.isEmpty(mEmail)){
                Member member = memberService.queryByEmail(mEmail);
                if (member.getMEmail().equals(mEmail)){
                    return Result.success(member);
                }
                return Result.error();
            }
            return Result.error();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
    @GetMapping("/countMember")
    public Result countMember(){
        try {
            int row = memberService.countMember();
            return Result.success(row);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
    @GetMapping("/queryAll")
    public Result queryAll(@RequestParam(defaultValue = "1") Integer currentPage, @RequestParam(defaultValue = "10") Integer pageSize){
        try {
            PageInfo<Member> all = memberService.queryAll(currentPage, pageSize);
            return Result.success(all);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.error();
        }
    }
}
