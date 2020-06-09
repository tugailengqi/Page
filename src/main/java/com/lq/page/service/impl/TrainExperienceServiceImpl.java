package com.lq.page.service.impl;

import com.lq.page.domain.entity.TrainExperience;
import com.lq.page.mapper.TrainExperienceMapper;
import com.lq.page.service.TrainExperienceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("/trainExperienceService")
public class TrainExperienceServiceImpl implements TrainExperienceService {
    @Resource
    TrainExperienceMapper trainExperienceMapper;
    @Override
    public int insertTrainExperience(TrainExperience trainExperience) {
        return trainExperienceMapper.insertTrain(trainExperience);
    }

    @Override
    public int updateTrain(TrainExperience train) {
        return trainExperienceMapper.updateTrain(train);
    }

}
