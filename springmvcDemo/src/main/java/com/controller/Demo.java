package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 描述: TODO
 * Author: Ming
 * Date: 2020/2/19 0:51
 * version: 1.0
 */
@Controller
public class Demo {
    @RequestMapping(value = "/test.so")
    public String getItemList(){
        return "itemList";
    }
}
