package com.lq.page.service;

import com.github.pagehelper.PageInfo;
import com.lq.page.domain.entity.PageBean;
import com.lq.page.domain.entity.Position;

import java.util.List;

public interface PositionService {
    int selectCountPosition();
    PageBean<Position> findByPage(int currentPage, int pageSize);
    PageBean<Position> searchLocation(String[] workPosition,int currentPage, int pageSize);
    PageBean<Position> searchByName(String positionName,int currentPage, int pageSize);
    PageBean<Position> searchByType(String[] positionType,int currentPage, int pageSize);
    Position findById(String pId,Integer flag);
    int addPosition(Position position);
    PageInfo<Position> queryByMid(Integer mid,Integer flag, Integer currentPage, Integer pageSize);
    int updatePosition(Position position);
    int updateFlag(String pId,Integer flag);
    int isDelete(String pId);
}
