package com.lq.page.mapper;

import com.lq.page.domain.entity.Progress;
import org.apache.ibatis.annotations.Param;

public interface ProgressMapper {
    Progress queryByMid(@Param("mid") Integer mid);
    int insert(@Param("progress") Progress progress);
}