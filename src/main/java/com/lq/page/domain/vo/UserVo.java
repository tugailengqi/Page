package com.lq.page.domain.vo;

import com.lq.page.domain.entity.User;
import com.lq.page.domain.entity.UserInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserVo extends User {
    UserInfo userInfo;
}
