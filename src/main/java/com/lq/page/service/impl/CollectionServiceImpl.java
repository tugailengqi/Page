package com.lq.page.service.impl;

import com.lq.page.domain.entity.CollectionBean;
import com.lq.page.mapper.CollectionMapper;
import com.lq.page.service.CollectionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("collectionService")
public class CollectionServiceImpl implements CollectionService {

    @Resource
    private CollectionMapper collectionMapper;

    @Override
    public int insertCollection(int uId, String pId) {
        return collectionMapper.addCollection(uId, pId);
    }

    @Override
    public List<CollectionBean> findCollectionByUid(int uId) {
        return collectionMapper.findByUid(uId);
    }

    @Override
    public int deleteCollection(int uId, String pId) {
        return collectionMapper.deleteCollection(uId, pId);
    }

    @Override
    public int updateFlag(Integer flag,Integer uid,String pId) {
        return collectionMapper.updateFlag(flag, uid,pId);
    }
}
