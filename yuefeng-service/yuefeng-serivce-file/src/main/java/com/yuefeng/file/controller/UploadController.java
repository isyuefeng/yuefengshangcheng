package com.yuefeng.file.controller;

import com.yuefeng.file.FastDFSFile;
import com.yuefeng.file.util.FastDFSClient;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author yf
 * @date 2021/10/7
 **/
@RestController
public class UploadController {

    @PostMapping("/upload")
    public String upload(@RequestParam(name = "file")MultipartFile file){
        try {
            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();

                //获取文件扩展名
                String extName = StringUtils.getFilenameExtension(file.getOriginalFilename());
                FastDFSFile filex = new FastDFSFile(file.getOriginalFilename(),bytes,extName);
                String[] upload = FastDFSClient.upload(filex);

                String realPath = "http://47.102.205.134:8080/" + upload[0] + "/" + upload[1];

                //4.拼接URL 返回给前端
                return realPath;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }



}
