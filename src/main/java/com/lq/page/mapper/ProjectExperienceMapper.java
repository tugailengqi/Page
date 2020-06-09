package com.lq.page.mapper;

import com.lq.page.domain.entity.ProjectExperience;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectExperienceMapper {

    int insert(@Param("projectExperience") ProjectExperience projectExperience);
    int update(@Param("project")ProjectExperience projectExperience);
}