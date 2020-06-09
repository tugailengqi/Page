package com.lq.page.domain.entity;

import lombok.Data;

@Data
public class UserInfo {
    /**
    * 用户基本信息id
    */
    private Integer uInfoId;

    /**
    * 外键
    */
    private Integer uId;

    private String username;

    private String phone;

    private String email;

    /**
    * 工作年限
    */
    private String workExperience;

    /**
    * 现居住地
    */
    private String nowPalce;

    /**
    * 期望工作地
    */
    private String wishWorkplace;

    /**
    * 最高学历
    */
    private String mostEducation;

}