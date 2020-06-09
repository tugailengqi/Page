package com.lq.page.controller;

import com.lq.page.utils.Result;
import com.lq.page.utils.UploadFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/upload")
public class UploadController {
    private UploadFile uploadFile;

    /**
     * 单个文件上传
     * @param multipartFile
     * @return
     */
    @RequestMapping("/formUpload")
    public Result formUpload(@RequestParam(value = "file") MultipartFile multipartFile){
        if (multipartFile.isEmpty()) {
            return Result.error();
        }
        uploadFile = new UploadFile();
        uploadFile.saveFile(multipartFile);
        return Result.success("hello");
    }

    /**
     * 多文件上传
     * 注意：如果是多个个文件，则将其设为数组类型
     * @param multipartFile
     * @return
     */
    @RequestMapping("formUploadSeveral/")
    public String formUploadSeveral(@RequestParam(value = "file") MultipartFile[] multipartFile){
        if (multipartFile!=null){
            for (MultipartFile file : multipartFile) {
                uploadFile.saveFile(file);
            }
        }
        return "ok";
    }
}
