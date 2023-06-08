package com.example.tasklist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class HomeController {
    @Autowired
    private HelloService service;
    @GetMapping("/bay")
    public String getBay() {
        return "bay";
    }
    @PostMapping("/bay")
    public String postRequest(@RequestParam("text1") String str, Model model) {
        model.addAttribute("sample", str);
        return "bay/response";
    }
    @PostMapping("/bay/db")
    public String postDbRequest(@RequestParam("text2") String id, Model model) {
        Employee employee = service.getEmployee(id);
        model.addAttribute("employee", employee);
        return "bay/db";
    }
}
