package com.lq.page.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lq.page.domain.entity.PageBean;
import com.lq.page.domain.entity.Position;
import com.lq.page.mapper.PositionMapper;
import com.lq.page.service.PositionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service("positionService")
public class PositionServiceImpl implements PositionService {
    @Resource
    PositionMapper positionMapper;

    @Override
    public int selectCountPosition() {
        return positionMapper.selectCount();
    }

    @Override
    public PageBean<Position> findByPage(int currentPage, int pageSize) {
        HashMap<String,Object> map = new HashMap<>();
        PageBean<Position> pageBean = new PageBean<>();

        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(pageSize);

        int totalCount = positionMapper.selectCount();
        pageBean.setTotalCount(totalCount);

        double num = Math.ceil((double) totalCount / pageSize);
        pageBean.setTotalPage((int) num);

        map.put("start",(currentPage-1)*pageSize);
        map.put("size",pageBean.getRows());
        List<Position> byPage = positionMapper.findByPage(map);
        pageBean.setList(byPage);
        return pageBean;
    }

    @Override
    public PageBean<Position> searchLocation(String[] workPosition,int currentPage, int pageSize) {
        PageBean<Position> pageBean = new PageBean<>();

        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(pageSize);

        int totalCount = positionMapper.countPositions(workPosition);
        pageBean.setTotalCount(totalCount);

        double num = Math.ceil((double) totalCount / pageSize);
        pageBean.setTotalPage((int) num);

        int start = (currentPage-1)*pageSize;
        int size = pageBean.getRows();
        List<Position> byPage = positionMapper.searchPage(workPosition,start,size);
        pageBean.setList(byPage);
        return pageBean;
    }

    @Override
    public PageBean<Position> searchByName(String positionName, int currentPage, int pageSize) {
        PageBean<Position> pageBean = new PageBean<>();
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(pageSize);
        int totalCount = positionMapper.countPosName(positionName);
        pageBean.setTotalCount(totalCount);
        double num = Math.ceil((double) totalCount / pageSize);
        pageBean.setTotalPage((int) num);
        int start = (currentPage-1)*pageSize;
        int size = pageBean.getRows();
        List<Position> byNamePage = positionMapper.searchByNamePage(positionName, start, size);
        pageBean.setList(byNamePage);
        return pageBean;
    }

    @Override
    public PageBean<Position> searchByType(String[] positionType, int currentPage, int pageSize) {
        PageBean<Position> pageBean = new PageBean<>();
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(pageSize);
        int totalCount = positionMapper.countPosType(positionType);
        pageBean.setTotalCount(totalCount);
        double num = Math.ceil((double) totalCount / pageSize);
        pageBean.setTotalPage((int) num);
        int start = (currentPage-1)*pageSize;
        int size = pageBean.getRows();
        List<Position> byTypePage = positionMapper.searchByTypePage(positionType, start, size);
        pageBean.setList(byTypePage);
        return pageBean;
    }

    @Override
    public Position findById(String pId,Integer flag) {
        return positionMapper.findById(pId,flag);
    }

    @Override
    public int addPosition(Position position) {
        return positionMapper.insertJob(position);
    }

    @Override
    public PageInfo<Position> queryByMid(Integer mid,Integer flag,Integer currentPage,Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Position> positions = positionMapper.findByMid(mid,flag);
        return new PageInfo<>(positions);
    }

    @Override
    public int updatePosition(Position position) {
        return positionMapper.updatePosition(position);
    }

    @Override
    public int updateFlag(String pId,Integer flag) {
        return positionMapper.updateFlag(pId,flag);
    }

    @Override
    public int isDelete(String pId) {
        return positionMapper.isDeletePosition(pId);
    }
}
