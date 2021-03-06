package com.cocky.springmvc.controller;

import com.cocky.springmvc.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * for RequestMapping /normal
 */
@Controller
public class NormalController {

    @Autowired
    DemoService demoService;

    @RequestMapping(value = "/normal")
    public String testPage(Model model) {
        model.addAttribute("msg", demoService.saySomething());
        return "page";
    }
}
