package com.lq.page.domain.entity;

import lombok.Data;

@Data
public class User {
    private Integer uId;

    private String username;

    private String password;

    private String sex;

    private String hobbys;

    private String phone;

    private String email;

    private String addrs;

    private Integer flag;
}