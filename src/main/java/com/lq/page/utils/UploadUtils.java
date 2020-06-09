package com.lq.page.utils;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

public class UploadUtils {
    public String upload(String path,MultipartFile multipartFile){
        //返回文件的类型，在此处
        String type = multipartFile.getContentType();
        String originalFilename = multipartFile.getOriginalFilename();
        if (originalFilename==null){
            return null;
        }
        int hashCode = originalFilename.hashCode();
        int dir1 = hashCode & 0xf;
        int dir2 = (hashCode & 0xf0) >> 4;
        String dir = path + File.separator+dir1 + File.separator + dir2;
        File file = new File(dir);
        //如果d:\1\2这个文件夹不存在，才创建
        if (!file.exists()){
            file.mkdirs();
        }
        String newFileName = UUID.randomUUID().toString().replace("-","")+"."+originalFilename.substring(originalFilename.lastIndexOf(".")+1);
//        multipartFile.transferTo("文件名+地址")，就可以不用io流方式存;
        InputStream is = null;
        OutputStream os = null;
        try {
            is = multipartFile.getInputStream();
            os = new FileOutputStream(dir+File.separator+newFileName);
            FileCopyUtils.copy(is,os);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return dir1+File.separator+dir2+File.separator+newFileName;
    }
}
