package com.lq.page.domain.entity;

import lombok.Data;

@Data
public class Admin {
    private Integer uid;

    private String username;

    private String password;

    private String tel;

    private String addr;
}