package com.lq.page.mapper;

import com.lq.page.domain.entity.EductionExperience;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EductionExperienceMapper {

    int insert(@Param("eduction") EductionExperience eduction);
    int update(@Param("eduction") EductionExperience eduction);
}