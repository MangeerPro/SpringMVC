package com.cocky.springmvc.controller;

import com.cocky.springmvc.domain.DemoObj;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //使用RestController，声明的是控制器，并且返回数据时不需要@ResponseBody
@RequestMapping("/rest")
public class DemoRestController {

    @RequestMapping(value = "/getjson", produces = {"application/json;charset=UTF-8"})
    public DemoObj getJson(DemoObj obj) {
        return new DemoObj(obj.getId() + 1, obj.getName() + "yy");  //返回的对象会自动转换为json
    }

    @RequestMapping(value = "/getxml", produces = {"applicationxml/xml;charset=UTF-8"})
    //返回的数据类型是xml
    public DemoObj getXml(DemoObj obj) {
        return new DemoObj(obj.getId() + 1, obj.getName() + "yy"); //直接返回对象，对象会自动转换为xml
    }
}
