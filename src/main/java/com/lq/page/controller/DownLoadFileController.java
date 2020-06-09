package com.lq.page.controller;

import com.lq.page.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Slf4j
@RestController
@RequestMapping("/down")
public class DownLoadFileController {
    @GetMapping("/downLoad")
    public Result downLoad(@RequestParam("filename")String filename, HttpServletRequest request, HttpServletResponse response){
        String path = "D:\\code\\week13\\Page\\src\\main\\webapp\\upload\\"+filename;
        try {
            filename = URLEncoder.encode(filename,"UTF-8");
            InputStream bis = new BufferedInputStream(new FileInputStream(new File(path)));
            response.setHeader("Content-Disposition","attachment;filename="+filename);
            BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
            int len = 0;
            while ((len = bis.read())!=-1){
                out.write(len);
                out.flush();
            }
            out.close();
            bis.close();
        } catch (IOException e) {
            log.error(e.getLocalizedMessage());
            return Result.error();
        }
        return Result.success("成功");
    }
}
