package com.lq.page.mapper;

import com.lq.page.domain.entity.Position;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.List;

public interface PositionMapper {
    //查找全部，分页

    int selectCount();
    List<Position> findByPage(HashMap<String,Object> map);

    //根据工作地点查找，分页
    List<Position> searchPage(@Param("workPosition")String[] workPosition,@Param("start") Integer start,@Param("size") Integer size);
    int countPositions(@Param("workPosition") String[] workPosition);

    //根据名称查找，分页
    int countPosName(@Param("positionName")String positionName);
    List<Position> searchByNamePage(@Param("positionName")String positionName,@Param("start") Integer start,@Param("size") Integer size);

    //根据类型查找，分页
    int countPosType(@Param("positionType") String[] positionType);
    List<Position> searchByTypePage(@Param("positionType")String[] positionType,@Param("start") Integer start,@Param("size") Integer size);

    //根据id查找
    Position findById(@Param("pId")String pId, @Param("flag")Integer flag);

    int insertJob(@Param("position") Position position);
    List<Position> findByMid(@Param("mId") Integer mId,@Param("flag") Integer flag);
    int updatePosition(@Param("position") Position position);

    int updateFlag(@Param("pId") String pId,@Param("flag") Integer flag);
    int isDeletePosition(@Param("pId")String pId);
}