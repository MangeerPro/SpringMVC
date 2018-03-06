package com.cocky.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  // 声明是一个控制器
public class HelloController {

    // 利用RequestMapping配置Url与方法之间的映射
    @RequestMapping("hello")
    public String hello() {
        // 通过上面ViewResolver的Bean配置，返回值为index，
        // 说明我的页面配置路径为"/WEB-INF/classes/views/index.jsp
        return "hello";
    }
}
