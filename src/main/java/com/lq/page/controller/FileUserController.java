package com.lq.page.controller;

import com.lq.page.service.FileUserService;
import com.lq.page.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/file")
public class FileUserController {
    @Resource
    FileUserService fileUserService;
    @PostMapping("/save")
    public Result addImg( MultipartFile multipartFile, int uInfoId, String image){
        try {
            if (multipartFile.isEmpty()) {
                return Result.error();
            }
            int rows = fileUserService.insertImage(multipartFile, uInfoId, image);
            return Result.success(rows);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
    @PostMapping("/updateImage")
    public Result updateImage(MultipartFile multipartFile,int mid,String image){
        try {
            if (multipartFile.isEmpty()) {
                return Result.error();
            }
            int rows = fileUserService.updateImg(multipartFile, mid, image);
            return Result.success(rows);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
    @PostMapping("/updateResume")
    public Result updateResume(MultipartFile file,int mid,String resume){
        try {
            if (file.isEmpty()) {
                return Result.error();
            }
            int rows = fileUserService.updateResume(file, mid, resume);
            return Result.success(rows);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
    @PostMapping("/updateWorks")
    public Result updateWorks(MultipartFile file,int mid,String works) {
        try {
            if (file.isEmpty()) {
                return Result.error();
            }
            int rows = fileUserService.updateWorkFile(file, mid, works);
            return Result.success(rows);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
    @PostMapping("/updateOther")
    public Result updateOther(MultipartFile file,int mid,String other){
        try {
            if (file.isEmpty()) {
                return Result.error();
            }
            int rows = fileUserService.updateOther(file, mid, other);
            return Result.success(rows);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }
}
