package com.djbx.bi.internet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller(value="/user")
public class LayuiController {

    @RequestMapping("/list")
    public String list(Map<String,Object> map){
        map.put("name", "william");
        map.put("age", 18);

        return "/list";
    }

    @RequestMapping("/find")
    public String find(){
        return "/find";
    }
}
