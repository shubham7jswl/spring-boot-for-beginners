package com.sj.springbootforbeginners.service;

import org.springframework.stereotype.Service;

@Service
public class AgricultureService {

    public String getCropStartsWith(String input){
        return "wheat";
    }
}
