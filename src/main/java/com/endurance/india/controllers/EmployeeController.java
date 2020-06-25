package com.endurance.india.controllers;

import com.endurance.india.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class EmployeeController
{
    @Autowired private EmployeeService employeeService;

//    @RequestMapping("/")
//    public String home(){
//        return "index";
//    }

    @RequestMapping("/employees")
    public String admin(Model model){
        model.addAttribute("mapList", employeeService.getListOfEmployees());
        return "employees";
    }
}