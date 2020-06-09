package com.lq.page.domain.entity;

import lombok.Data;

@Data
public class Progress {
    private Integer sId;

    /**
    * 企业id
    */
    private Integer mId;

    /**
    * 用户id
    */
    private Integer uId;

    /**
    * 是否接受
    */
    private Integer access;
}