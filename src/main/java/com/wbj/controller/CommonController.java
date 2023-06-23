package com.wbj.controller;

import com.wbj.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/common")
@Slf4j
public class CommonController {

    @Value("${common.basePath}")
    private String basePath;

    /**
     * 获取图片
     * @param name 图片名称
     * @param response 响应
     * @throws IOException
     */
    @GetMapping("image/{name}")
    public void download(@PathVariable String name, HttpServletResponse response) throws IOException {
        log.info("查询图片资源，路径：{}",basePath+name);
        FileInputStream fileInputStream = new FileInputStream(basePath+name);
        ServletOutputStream outputStream = response.getOutputStream();
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = fileInputStream.read(bytes)) != -1){
            outputStream.write(bytes);
            outputStream.flush();
        }
        fileInputStream.close();
        outputStream.close();
    }

    @PostMapping("upload")
    public R<String> upload(MultipartFile file) throws IOException {
        if (file == null){
            return R.fail("不能传null值！");
        }
        log.info("上传文件：{}",file.toString());
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName = UUID.randomUUID().toString() + suffix;
        file.transferTo(new File(basePath + fileName));
        return R.success(fileName,"添加文件成功！");
    }
}
