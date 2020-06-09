package com.lq.page.controller;

import com.alibaba.druid.util.StringUtils;
import com.lq.page.domain.entity.CollectionBean;
import com.lq.page.service.CollectionService;
import com.lq.page.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/collection")
public class CollectionController {

    @Resource
    private CollectionService collectionService;

    @RequestMapping("/addCollection")
    public Result addCollection(Integer uId,String pId){
        try {
            if (uId==null || uId<=0 || "".equals(pId) || pId == null){
                return Result.error();
            }
            int rows = collectionService.insertCollection(uId, pId);
            return Result.success(rows);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }

    @RequestMapping("/findCollByUid")
    public Result findCollByUid(Integer uId){
        try {
            if (uId<=0){
                return Result.error();
            }
            List<CollectionBean> byUid = collectionService.findCollectionByUid(uId);
            return Result.success(byUid);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
    @RequestMapping("/deleteCollection")
    public Result deleteCollection(Integer uId,String pId){

        try {
            if (uId==null || uId<=0 || "".equals(pId) || pId == null){
                return Result.error();
            }
            int rows = collectionService.deleteCollection(uId, pId);
            return Result.success(rows);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
    @PostMapping("/updateFlag")
    public Result updateFlag(Integer flag,Integer uid,String pId){
        try {
            if (flag<0 || uid <=0 || StringUtils.isEmpty(pId)){
                return Result.error();
            }
            int row = collectionService.updateFlag(flag,uid,pId);
            return Result.success(row);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
}
