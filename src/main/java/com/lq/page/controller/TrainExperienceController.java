package com.lq.page.controller;

import com.lq.page.domain.entity.TrainExperience;
import com.lq.page.service.TrainExperienceService;
import com.lq.page.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/train")
public class TrainExperienceController {
    @Resource
    TrainExperienceService trainExperienceService;
    @PostMapping("/insertTrain")
    public Result insertTrainExperience(TrainExperience experience){
        try {
            int rows = trainExperienceService.insertTrainExperience(experience);
            return Result.success(rows);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
    @PostMapping("/updateTrain")
    public Result updateTrain(TrainExperience train){
        try {
            int row = trainExperienceService.updateTrain(train);
            return Result.success(row);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
}
