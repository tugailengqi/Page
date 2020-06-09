package com.lq.page.mapper;

import com.lq.page.domain.entity.Pending;
import com.lq.page.domain.vo.ResumeAndPosition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PendingMapper {
    int insert(@Param("uInfoId") Integer uInfoId, @Param("flag") Integer flag,@Param("mid")Integer mid);
    List<ResumeAndPosition> findByFlag(@Param("flag") Integer flag,@Param("mid")Integer mid);
    List<ResumeAndPosition> findByWorkExperience(@Param("works") String[] works,@Param("educations")String[] educations,@Param("flag")Integer flag,@Param("mid")Integer mid);
    int delete(@Param("uInfoId") Integer uInfoId);
}