package com.lq.page.domain.entity;

import lombok.Data;

@Data
public class FileUser {
    /**
     * 文件图片id
     */
    private Integer mId;
    private Integer uInfoId;

    /**
     * 图片
     */
    private String image;

    /**
     * 简历
     */
    private String resume;

    /**
     * 作品
     */
    private String works;

    /**
     * 其他
     */
    private String other;
}