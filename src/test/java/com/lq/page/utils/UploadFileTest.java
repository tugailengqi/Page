package com.lq.page.utils;

import com.lq.page.domain.entity.Position;
import com.lq.page.mapper.PositionMapper;
import com.lq.page.service.PositionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class UploadFileTest {
    private static final String UPLOAD_DIR= "D:/code/week13/project1/src/image/banner.jpg";
    @Resource
    PositionMapper positionMapper;
    @Test
    public void saveFile() {
        Date date = new Date();
        Position position = new Position();
//        position.setPId(UUID.randomUUID().toString().replace("-",""));
//        position.setPublicTime(new SimpleDateFormat("yyyy年MM月dd日").format(date));
            position.setPId("3");
            position.setResponsibility("你好");
            position.setPositionName("你好");
        System.out.println(position);
        positionMapper.insertJob(position);
    }

    @Test
    public void test(){
        Date date = new Date();
        System.out.println(new SimpleDateFormat("yyyy年MM月dd日").format(date));
    }
}