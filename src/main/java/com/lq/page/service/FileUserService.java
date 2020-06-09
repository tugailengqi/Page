package com.lq.page.service;

import com.lq.page.domain.entity.FileUser;
import org.springframework.web.multipart.MultipartFile;

public interface FileUserService {
    int insertImage(MultipartFile file,int uInfoId, String image);
    int updateImg(MultipartFile file,int mid, String image);
    int updateResume(MultipartFile file,int mid,String resume);
    int updateWorkFile(MultipartFile file,int mid,String works);
    int updateOther(MultipartFile file,int mid,String other);
}
