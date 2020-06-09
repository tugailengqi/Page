package com.lq.page.service.impl;

import com.lq.page.domain.entity.EductionExperience;
import com.lq.page.mapper.EductionExperienceMapper;
import com.lq.page.service.EductionExperienceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("/eductionExperienceService")
public class EductionExperienceServiceImpl implements EductionExperienceService {

    @Resource
    EductionExperienceMapper experienceMapper;
    @Override
    public int insert(EductionExperience eductionExperience) {
        return experienceMapper.insert(eductionExperience);
    }

    @Override
    public int update(EductionExperience eductionExperience) {
        return experienceMapper.update(eductionExperience);
    }
}
