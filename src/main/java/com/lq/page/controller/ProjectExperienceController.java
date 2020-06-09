package com.lq.page.controller;

import com.lq.page.domain.entity.ProjectExperience;
import com.lq.page.service.ProjectExperienceService;
import com.lq.page.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/project")
public class ProjectExperienceController {

    @Resource
    ProjectExperienceService projectExperienceService;
    @PostMapping("/insertProject")
    public Result insertProject(ProjectExperience projectExperience){
        try {
            int rows = projectExperienceService.insert(projectExperience);
            return Result.success(rows);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
    @PostMapping("/updateProject")
    public Result updateProject(ProjectExperience project){
        try {
            int row = projectExperienceService.update(project);
            return Result.success(row);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
}
