package com.lq.page.mapper;

import com.lq.page.domain.entity.Apply;
import com.lq.page.domain.entity.CollectionBean;
import com.lq.page.domain.entity.Position;
import com.lq.page.domain.vo.ApplyVo;
import com.lq.page.domain.vo.ResumeAndPosition;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface ApplyMapper {
    /**
     * @param uId 用户id
     * @param pId 职位id
     * @return 影响的行数
     */
    int insertApply(@Param("uId") int uId, @Param("pId") String pId,@Param("mId") Integer mId);
    List<Apply> findByUid(@Param("uId") int uId);
    int deleteApply(@Param("uId") int uId, @Param("pId") String pId);
    List<ApplyVo> findByMid(@Param("mId") Integer mId,@Param("access") Integer access);
    List<ApplyVo> findByWorkExperience(@Param("workExperience") String[] workExperience,@Param("education") String[] education,@Param("access")Integer access);
    int updateAccess(@Param("access") Integer access,@Param("uid")Integer[] uid);

}