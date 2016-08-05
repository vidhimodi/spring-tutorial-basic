package com.endurance.india.controllers;

import com.endurance.india.dao.TinyUrlMappingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired private TinyUrlMappingDao tinyUrlMappingDao;

    @RequestMapping("/")
    public String admin(Model model){
        model.addAttribute("mapList", tinyUrlMappingDao.findAll());
        return "admin";
    }

}