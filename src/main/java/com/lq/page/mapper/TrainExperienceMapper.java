package com.lq.page.mapper;


import com.lq.page.domain.entity.TrainExperience;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TrainExperienceMapper {
    int insertTrain(@Param("record") TrainExperience record);
    int updateTrain(@Param("record") TrainExperience record);
}