package com.lq.page.controller;

import com.lq.page.domain.entity.Progress;
import com.lq.page.service.ProgressService;
import com.lq.page.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/progress")
public class ProgressController {
    @Resource
    ProgressService progressService;
    @GetMapping("/findByMid")
    public Result findByMid(Integer mid){
        try {
            if (mid<0){
                return Result.error();
            }
            Progress progress = progressService.queryById(mid);
            return Result.success(progress);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
    @PostMapping("/insertProgress")
    public Result insertProgress(Progress progress){
        try {
            int row = progressService.insert(progress);
            return Result.success(row);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
}
