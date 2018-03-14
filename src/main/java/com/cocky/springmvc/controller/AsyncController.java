package com.cocky.springmvc.controller;

import com.cocky.springmvc.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

@Controller
public class AsyncController {

    @Autowired
    PushService pushService; //定时任务，定时更新DeferredResult

    @RequestMapping("/defer")
    @ResponseBody
    public DeferredResult<String> deferredCall() {  //返回给客户端DeferredResult
        return pushService.getAsyncUpdate();
    }
}
