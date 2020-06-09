package com.lq.page.domain.entity;


import lombok.Data;

@Data
public class ProjectExperience {
    /**
    * 项目经历id
    */
    private Integer proId;

    private Integer uInfoId;

    /**
    * 项目名
    */
    private String projectName;

    private String projectStartTime;

    private String projectEndTime;

    /**
    * 职责描述
    */
    private String responsibilities;
}