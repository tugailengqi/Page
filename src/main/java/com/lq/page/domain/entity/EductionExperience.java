package com.lq.page.domain.entity;

import java.util.Date;
import lombok.Data;

@Data
public class EductionExperience {
    /**
    * 教育经历id
    */
    private Integer eId;

    private Integer uInfoId;

    /**
    * 学校
    */
    private String school;

    /**
    * 专业
    */
    private String major;

    /**
    * 开始时间
    */
    private String educationStartTime;

    /**
    * 结束时间
    */
    private String educationEndTime;

    /**
    * 学历
    */
    private String education;

    /**
    * 专业描述
    */
    private String majorDescription;
}