package com.lq.page.domain.vo;

import com.lq.page.domain.entity.Apply;
import com.lq.page.domain.entity.Position;
import com.lq.page.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplyVo extends Apply {

    List<Position> positionList;
    List<User> userList;
    ResumeAndPosition resumeAndPosition;
}
