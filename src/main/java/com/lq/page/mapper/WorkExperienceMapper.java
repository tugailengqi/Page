package com.lq.page.mapper;


import com.lq.page.domain.entity.WorkExperience;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkExperienceMapper {
    int insertWorkExperience(@Param("workExperience") WorkExperience workExperience);
    int updateWork(@Param("work") WorkExperience workExperience);
}