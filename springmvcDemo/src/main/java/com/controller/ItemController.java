package com.controller;

import com.pojo.Items;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;

/**
 * 描述: 商品管理
 * Author: Ming
 * Date: 2020/2/19 21:55
 * version: 1.0
 */
@Controller
public class ItemController {
    @RequestMapping(value = "/item/itemlist.action")
    public ModelAndView getItemList(){
        ModelAndView modelAndView = new ModelAndView();

        ArrayList<Items> itemsList = new ArrayList<>();
        itemsList.add(new Items(1, "1华为 荣耀8", 2399f, new Date(), "质量好！1"));
        itemsList.add(new Items(2, "1华为 荣耀8", 2399f, new Date(), "质量好！1"));
        itemsList.add(new Items(3, "1华为 荣耀8", 2399f, new Date(), "质量好！1"));
        itemsList.add(new Items(4, "1华为 荣耀8", 2399f, new Date(), "质量好！1"));

        modelAndView.setViewName("/WEB-INF/jsp/itemList.jsp");
        modelAndView.addObject("itemList",itemsList);
        return modelAndView;
    }
}
