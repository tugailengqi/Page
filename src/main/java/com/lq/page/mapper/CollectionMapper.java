package com.lq.page.mapper;

import com.lq.page.domain.entity.CollectionBean;import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface CollectionMapper {

    /**
     * @param uId 用户id
     * @param pId 职位id
     * @return 影响的行数
     */
    int addCollection(@Param("uId") int uId, @Param("pId") String pId);
    List<CollectionBean> findByUid(@Param("uId") int uId);
    int deleteCollection(@Param("uId") int uId, @Param("pId") String pId);
    int updateFlag(@Param("flag")Integer flag,@Param("uid")Integer uid,@Param("pId")String  pId);
}