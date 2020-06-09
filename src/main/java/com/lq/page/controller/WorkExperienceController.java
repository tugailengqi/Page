package com.lq.page.controller;

import com.lq.page.domain.entity.WorkExperience;
import com.lq.page.service.WorkExperienceService;
import com.lq.page.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/work")
public class WorkExperienceController {

    @Resource
    WorkExperienceService workExperienceService;

    @PostMapping("/insertWorkExperience")
    public Result insertWorkExperience(WorkExperience workExperience){
        try {
            int rows = workExperienceService.insertWorkExperience(workExperience);
            return Result.success(rows);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
    @PostMapping("/updateWork")
    public Result updateWork(WorkExperience work){
        try {
            int row = workExperienceService.updateWork(work);
            return Result.success(row);
        } catch (Exception e) {
           log.error(e.getMessage());
        }
        return Result.error();
    }
}
