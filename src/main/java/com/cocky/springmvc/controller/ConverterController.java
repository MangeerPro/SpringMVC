package com.cocky.springmvc.controller;

import com.cocky.springmvc.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConverterController {

    /**
     * 指定返回的媒体类型为我们自定义的媒体类型application/x-wisely
     * @param demoObj
     * @return
     */
    @RequestMapping(value = "/convert", produces = {"application/x-wisely"})
    public @ResponseBody
    DemoObj convert(@RequestBody DemoObj demoObj) {
        return demoObj;
    }

}
