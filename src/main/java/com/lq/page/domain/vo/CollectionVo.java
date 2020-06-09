package com.lq.page.domain.vo;

import com.lq.page.domain.entity.CollectionBean;
import com.lq.page.domain.entity.Position;
import com.lq.page.domain.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class CollectionVo extends CollectionBean {
    List<Position> positionList;
    List<User> userList;
}