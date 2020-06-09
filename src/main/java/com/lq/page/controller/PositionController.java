package com.lq.page.controller;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageInfo;
import com.lq.page.domain.entity.PageBean;
import com.lq.page.domain.entity.Position;
import com.lq.page.service.PositionService;
import com.lq.page.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/position")
public class PositionController {
    @Resource
    PositionService positionService;
    @RequestMapping("/findAll")
    public Result findAll(Integer currentPage, Integer pageSize){
        try {
            PageBean<Position> positions = positionService.findByPage(currentPage,pageSize);
            return Result.success(positions);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }

    @RequestMapping("/searchLocation")
    public Result searchLocation(String[] workPosition,Integer currentPage, Integer pageSize){

        try {
            if (workPosition.length == 0){
                Result all = findAll(currentPage, pageSize);
                return Result.success(all);
            }
            PageBean<Position> pageBean = positionService.searchLocation(workPosition,currentPage,pageSize);
            return Result.success(pageBean);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
    @RequestMapping("/searchByName")
    public Result searchByName(String positionName,Integer currentPage, Integer pageSize){
        try {
            if ("".equals(positionName) || positionName==null){
                return Result.error();
            }
            PageBean<Position> searchByName = positionService.searchByName(positionName, currentPage, pageSize);
            return Result.success(searchByName);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
    @RequestMapping("/searchByType")
    public Result searchByType(String[] positionType,Integer currentPage, Integer pageSize){
        try {
            if (positionType.length==0){
                Result all = findAll(currentPage, pageSize);
                return Result.success(all);
            }
            PageBean<Position> byType = positionService.searchByType(positionType, currentPage, pageSize);
            return Result.success(byType);
        } catch (Exception e) {
           log.error(e.getMessage());
        }
        return Result.error();
    }

    @RequestMapping("/findById")
    public Result findById(String pId,@RequestParam(defaultValue = "0") Integer flag){
        try {
            if ("".equals(pId) || pId == null){
                return Result.error();
            }
            Position byId = positionService.findById(pId,flag);
            return Result.success(byId);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
    @PostMapping("/insert")
    public Result insertPosition(Position position){
        Date date = new Date();
        try {
            position.setPId(UUID.randomUUID().toString().replace("-",""));
            position.setPublicTime(new SimpleDateFormat("yyyy年MM月dd日").format(date));
            int row = positionService.addPosition(position);
            return Result.success(row);
        } catch (Exception e) {
           log.error(e.getMessage());
        }
        return Result.error();
    }
    @GetMapping("/findByMid")
    public Result findByMid(Integer mId,Integer flag, @RequestParam(defaultValue = "1")Integer currentPage, @RequestParam(defaultValue = "5")Integer pageSize){
        try {
            if (mId <0 ){
                return Result.error();
            }
            PageInfo<Position> byMid = positionService.queryByMid(mId,flag, currentPage, pageSize);
            return Result.success(byMid);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
    @PostMapping("/updateJob")
    public Result updateJob(Position position){
        Date date = new Date();
        try {
            position.setPublicTime(new SimpleDateFormat("yyyy年MM月dd日").format(date));
            int rows = positionService.updatePosition(position);
            return Result.success(rows);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
    @PostMapping("/updateFlag")
    public Result updateFlag(String pId,Integer flag){
        try {
            if (StringUtils.isEmpty(pId)){
                return Result.error();
            }
            int row = positionService.updateFlag(pId,flag);
            return Result.success(row);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
    @PostMapping("/isDeletePosition")
    public Result isDeletePosition(String pId){
        try {
            if (StringUtils.isEmpty(pId)){
                return Result.error();
            }
            int row = positionService.isDelete(pId);
            return Result.success(row);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
    @GetMapping("/selectCount")
    public Result selectCount(){
        try {
            int row = positionService.selectCountPosition();
            return Result.success(row);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
}
