package com.lq.page.service.impl;

import com.lq.page.domain.entity.ProjectExperience;
import com.lq.page.mapper.ProjectExperienceMapper;
import com.lq.page.service.ProjectExperienceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("/projectExperienceService")
public class ProjectExperienceServiceImpl implements ProjectExperienceService {

    @Resource
    ProjectExperienceMapper projectExperienceMapper;
    @Override
    public int insert(ProjectExperience projectExperience) {

        return projectExperienceMapper.insert(projectExperience);
    }

    @Override
    public int update(ProjectExperience project) {
        return projectExperienceMapper.update(project);
    }


}
