package com.lq.page.domain.entity;


import com.sun.istack.internal.NotNull;
import lombok.Data;
import lombok.NonNull;


@Data
public class Member {

    private Integer mId;

    /**
    * 会员名，建议使用企业简称
    */

    private String mName;

    /**
    * 用户名
    */

    private String mEmail;

    private Integer flag;
    private String password;
    private String location;
}