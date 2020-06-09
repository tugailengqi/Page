package com.lq.page.domain.entity;

import lombok.Data;

@Data
public class CollectionBean {
    /**
    * 收藏id
    */
    private Integer cId;

    /**
    * 外键
    */
    private String pId;
    /**
     * 外键
     */
    private Integer uId;
    private Integer cFlag;

}