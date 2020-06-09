package com.lq.page.controller;

import com.lq.page.domain.entity.EductionExperience;
import com.lq.page.service.EductionExperienceService;
import com.lq.page.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/education")
public class EductionExperienceController {

    @Resource
    EductionExperienceService service;
    @PostMapping("/insert")
    public Result insert(EductionExperience experience){
        try {
            int rows = service.insert(experience);
            return Result.success(rows);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
    @PostMapping("/update")
    public Result update(EductionExperience education){
        try {
            int row = service.update(education);
            return Result.success(row);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
}
