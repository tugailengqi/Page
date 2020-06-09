package com.lq.page.domain.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TrainExperience {
    /**
    * 培训id
    */
    private Integer tId;

    /**
    * 培训机构
    */
    private String trainInstitutions;

    /**
    * 证书
    */
    private String certificate;

    /**
    * 培训内容
    */
    private String trainContents;

    private Integer uInfoId;
    private String trainStartTime;
    private String trainEndTime;
}