package com.lq.page.service;

import com.lq.page.domain.entity.CollectionBean;

import java.util.List;

public interface CollectionService {
    int insertCollection(int uId,String pId);
    List<CollectionBean> findCollectionByUid(int uId);
    int deleteCollection(int uId,String pId);
    int updateFlag(Integer flag,Integer uid,String pId);
}
