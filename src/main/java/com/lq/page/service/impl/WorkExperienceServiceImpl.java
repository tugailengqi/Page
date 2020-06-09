package com.lq.page.service.impl;

import com.lq.page.domain.entity.WorkExperience;
import com.lq.page.mapper.WorkExperienceMapper;
import com.lq.page.service.WorkExperienceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("/workExperienceService")
public class WorkExperienceServiceImpl implements WorkExperienceService {

    @Resource
    WorkExperienceMapper workExperienceMapper;

    @Override
    public int insertWorkExperience(WorkExperience workExperience) {
        return workExperienceMapper.insertWorkExperience(workExperience);
    }

    @Override
    public int updateWork(WorkExperience work) {
        return workExperienceMapper.updateWork(work);
    }
}
