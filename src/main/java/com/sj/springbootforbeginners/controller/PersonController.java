package com.sj.springbootforbeginners.controller;

import com.sj.springbootforbeginners.model.Person;
import com.sj.springbootforbeginners.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/people")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/age-above")
    public List<Person> getPeopleAboveAge(@RequestParam int age) {
        return personRepository.findByAgeGreaterThan(age);
    }
}
