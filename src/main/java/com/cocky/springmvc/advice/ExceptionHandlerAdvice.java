package com.cocky.springmvc.advice;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice /* 声明一个控制器建言，自动注册为Spring的Bean*/
public class ExceptionHandlerAdvice {

    @ExceptionHandler(value = Exception.class)
    //同过ExceptionHandler的value属性，可以设置过滤拦截的条件，此处拦截所有的Exception
    public ModelAndView exception(Exception exception, WebRequest request) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorMessage", exception.getMessage());
        return modelAndView;
    }

    @ModelAttribute
    //此处使用ModelAttribute注解将键值对添加到全局，所有注解的@RequestMapping可以获取此键值对
    public void addAttribute(Model model) {
        model.addAttribute("msg", "额外信息");
    }

    @InitBinder
    //定制WebDataBinder
    public void initBinder(WebDataBinder webDataBinder) {
        //此处演示忽略request参数的id
        webDataBinder.setDisallowedFields("id");
    }
}
