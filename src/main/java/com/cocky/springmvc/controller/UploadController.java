package com.cocky.springmvc.controller;

import ch.qos.logback.core.util.FileUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody
    String upload(MultipartFile file) {

        try {
            System.out.println("++++++++++++++++++" + "classpath:/upload/");
            FileUtils.writeByteArrayToFile(new File("classpath:/upload/" + file.getOriginalFilename()), file.getBytes());
            return "ok";
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }
}
