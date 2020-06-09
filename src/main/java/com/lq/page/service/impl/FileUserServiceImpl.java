package com.lq.page.service.impl;

import com.lq.page.domain.entity.FileUser;
import com.lq.page.mapper.FileUserMapper;
import com.lq.page.service.FileUserService;
import com.lq.page.utils.UploadUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.util.UUID;

@Service("/fileUserService")
public class FileUserServiceImpl implements FileUserService {
    @Resource
    FileUserMapper fileUserMapper;
    private static final String UPLOAD_DIR= "D:\\code\\week13\\Page\\src\\main\\webapp\\upload\\";
    private UploadUtils uploadUtils = new UploadUtils();
    @Override
    public int insertImage(MultipartFile multipartFile,int uInfoId, String image) {
        image = uploadUtils.upload(UPLOAD_DIR, multipartFile);
        return fileUserMapper.addImage(uInfoId,image);
    }

    @Override
    public int updateImg(MultipartFile file, int mid, String image) {
        image = uploadUtils.upload(UPLOAD_DIR, file);
        return fileUserMapper.updateImg(mid,image);
    }

    @Override
    public int updateResume(MultipartFile file, int mid, String resume) {
        resume = uploadUtils.upload(UPLOAD_DIR,file);
        return fileUserMapper.updateresume(mid, resume);
    }

    @Override
    public int updateWorkFile(MultipartFile file, int mid, String works) {
        works = uploadUtils.upload(UPLOAD_DIR,file);
        return fileUserMapper.updateWorkFile(mid, works);
    }

    @Override
    public int updateOther(MultipartFile file, int mid, String other) {
        other = uploadUtils.upload(UPLOAD_DIR,file);
        return fileUserMapper.updateOther(mid, other);
    }
}
