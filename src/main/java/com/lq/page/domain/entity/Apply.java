package com.lq.page.domain.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Apply {
    private Integer aId;

    private String pId;
    private Date crtTime;
    private Integer uId;
    private Integer mId;
    //0表示默认，1表示合适，2表示不合适
    private Integer access;
}