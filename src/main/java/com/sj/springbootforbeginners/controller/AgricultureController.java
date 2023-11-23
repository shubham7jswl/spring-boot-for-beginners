package com.sj.springbootforbeginners.controller;

import com.sj.springbootforbeginners.service.AgricultureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/agricultureOperation/")
public class AgricultureController {
    @Autowired
    AgricultureService agricultureService;

    @GetMapping(value = "/getAllCrops")
    public List<String> getAllCrops(){
        return Arrays.asList("wheat","chana");
    }
    @GetMapping(value = "/getCropStartsWith")
    public String getCropStartsWith(String input){
        return agricultureService.getCropStartsWith(input);
    }
}
