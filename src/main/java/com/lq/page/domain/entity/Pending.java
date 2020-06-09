package com.lq.page.domain.entity;

import lombok.Data;

@Data
public class Pending {
    private Integer rId;

    private Integer uInfoId;

    /**
    * 1表示添加，0表示默认
    */
    private Integer flag;
    private Integer mId;
}