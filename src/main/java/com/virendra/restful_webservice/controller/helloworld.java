package com.virendra.restful_webservice.controller;

import com.virendra.restful_webservice.bean.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloworld {
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World 🌎";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World 🌎");
    }

    @GetMapping("/hello-world/{name}")
    public HelloWorldBean helloWorldPath(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World, %s",name));
    }
}
