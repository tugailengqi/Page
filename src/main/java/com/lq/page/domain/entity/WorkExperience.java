package com.lq.page.domain.entity;

import java.util.Date;
import lombok.Data;

@Data
public class WorkExperience {
    /**
    * 工作经历id
    */
    private Integer workId;

    private Integer uInfoId;

    /**
    * 工作单位
    */
    private String workUnit;

    private String job;


    /**
    * 工作开始时间
    */
    private String workStartTime;

    /**
    * 工作结束时间
    */
    private String workEndTime;

    /**
    * 职责描述
    */
    private String workResponsibilities;
}