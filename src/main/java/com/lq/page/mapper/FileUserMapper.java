package com.lq.page.mapper;

import com.lq.page.domain.entity.FileUser;
import org.apache.ibatis.annotations.Param;

public interface FileUserMapper {
    int addImage(@Param("uInfoId") int uInfoId,@Param("image") String image);
    int updateImg(@Param("mid")Integer mid,@Param("image") String image);
    int updateresume(@Param("mid") int mid,@Param("resume") String resume);
    int updateWorkFile(@Param("mid") int mid,@Param("works") String works);
    int updateOther(@Param("mid") int mid,@Param("other") String other);

}