package com.lq.page.domain.vo;

import com.lq.page.domain.entity.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Data
public class ResumeAndPosition extends UserInfo {
    List<WorkExperience> workExperienceList;
    List<EductionExperience> eductionExperienceList;
    List<ProjectExperience> projectExperienceList;
    List<TrainExperience> trainExperienceList;
    FileUser fileUserList;
    User user;
}
