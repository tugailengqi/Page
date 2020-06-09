package com.lq.page.utils;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

public class UploadFile {
    private static final String UPLOAD_DIR= "D:\\code\\week13\\Page\\src\\main\\webapp\\upload\\";
    public void saveFile(MultipartFile multipartFile){
        //  System.out.println(file.getSize());
//        //文件的原始名称
//        System.out.println(multipartFile.getOriginalFilename());
//        //前端页面中文件域的名称
//        System.out.println(file.getName());
        //1.判断文件是否存在
        File file = new File(UPLOAD_DIR);
        if (!file.exists()){
            file.mkdirs();
        }
        //2.构建保存文件的文件名：uuid+原来的文件的类型
        String oldFileName = multipartFile.getOriginalFilename();
        if (oldFileName==null){
            return;
        }
        String newFileName = UUID.randomUUID().toString().replace("-","")+"."+oldFileName.substring(oldFileName.lastIndexOf(".")+1);
        //        3.将上传以后的文件对应的输入流拷贝到服务器文件对应的输出流---文件上传的本质
        InputStream is = null;
        OutputStream os = null;
        try{
            is = multipartFile.getInputStream();
            os = new FileOutputStream(UPLOAD_DIR + newFileName);
            FileCopyUtils.copy(is,os);
        }catch (IOException e){
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
    }
}
