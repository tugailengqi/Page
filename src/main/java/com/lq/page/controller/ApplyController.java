package com.lq.page.controller;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageInfo;
import com.lq.page.domain.entity.Apply;
import com.lq.page.domain.vo.ApplyVo;
import com.lq.page.service.ApplyService;
import com.lq.page.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/apply")
public class ApplyController {
    @Resource
    ApplyService applyService;
    @RequestMapping(value = "/insertApply")
    public Result insertApply(Integer uId,String pId,Integer mId){
        try {
            if (uId==null || uId<=0 || "".equals(pId) || pId == null || mId==null || mId<=0 ){
                return Result.error();
            }
            int i = applyService.insertApply(uId, pId,mId);
            return Result.success(i);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
    @RequestMapping("/queryApply")
    public Result queryApply(Integer uId){
        try {
            if (uId <= 0){
                return Result.error();
            }
            List<Apply> list = applyService.findApplyByUid(uId);
            return Result.success(list);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
    @RequestMapping("/deleteApply")
    public Result deleteApply(Integer uId,String pId){
        try {
            if (uId==null || uId<=0 || "".equals(pId) || pId == null){
                return Result.error();
            }
            int rows = applyService.deleteApply(uId, pId);
            return Result.success(rows);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
    @GetMapping("/queryByMid")
    public Result queryByMid(Integer mId,@RequestParam(defaultValue = "0") Integer access, @RequestParam(defaultValue = "1") Integer currentPage, @RequestParam(defaultValue = "5") Integer pageSize){
        try {
            if (mId<0){
                return Result.error();
            }
            PageInfo<ApplyVo> pageInfo = applyService.findByMid(mId,access,currentPage,pageSize);
            return Result.success(pageInfo);
        } catch (Exception e) {
           log.error(e.getMessage());
        }
        return Result.error();
    }
    @GetMapping("/queryByWorkExperience")
    public Result queryByWorkExperience(String[] workExperience,String[] education,@RequestParam(defaultValue = "0") Integer access,@RequestParam(defaultValue = "1") Integer currentPage, @RequestParam(defaultValue = "5") Integer pageSize){
        try {
            if (workExperience.length == 0 || education.length ==0){
                return Result.error();
            }
            PageInfo<ApplyVo> works = applyService.findByWorks(workExperience,education, access,currentPage, pageSize);
            return Result.success(works);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
    @PostMapping("/update")
    public Result update(Integer access,Integer[] uid){
        try {
            if (access <0 || uid.length == 0){
                return Result.error();
            }
            int row = applyService.updateAccess(access, uid);
            return Result.success(row);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
}
