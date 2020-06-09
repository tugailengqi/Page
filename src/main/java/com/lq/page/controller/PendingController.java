package com.lq.page.controller;

import com.github.pagehelper.PageInfo;
import com.lq.page.domain.vo.ResumeAndPosition;
import com.lq.page.service.PendingService;
import com.lq.page.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/pending")
public class PendingController {
    @Resource
    PendingService pendingService;
    @PostMapping("/insert")
    public Result insert(Integer uInfoId,Integer flag,Integer mid){
        try {
            if (uInfoId <0 || flag <0 || flag>1 || mid<=0){
                return Result.error();
            }
            int row = pendingService.addPend(uInfoId, flag,mid);
            return Result.success(row);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
    @GetMapping("/findByFlag")
    public Result findByFlag(Integer flag,Integer mid, @RequestParam(defaultValue = "1") Integer currentPage, @RequestParam(defaultValue = "10") Integer pageSize){
        try {
            if (flag <0 || flag >1 || mid <=0){
                return Result.error();
            }
            PageInfo<ResumeAndPosition> resumeAndPositions = pendingService.queryByFlag(flag,mid, currentPage, pageSize);
            return Result.success(resumeAndPositions);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
    @GetMapping("/queryByWorkExperience")
    public Result queryByWorkExperience(String[] workExperience,String[] education,Integer flag,Integer mid,@RequestParam(defaultValue = "1") Integer currentPage, @RequestParam(defaultValue = "10") Integer pageSize){
        try {
            if (workExperience.length == 0 || education.length ==0|| flag <0 || flag >1 || mid <=0){
                return Result.error();
            }
            PageInfo<ResumeAndPosition> experience = pendingService.queryByWorkExperience(workExperience, education,flag,mid, currentPage, pageSize);
            return Result.success(experience);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
    @PostMapping("/delete")
    public Result delete(Integer uInfoId){
        try {
            if (uInfoId <= 0){
                return Result.error();
            }
            int row = pendingService.deletePend(uInfoId);
            return Result.success(row);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
}
