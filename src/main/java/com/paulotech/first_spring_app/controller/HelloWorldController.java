package com.paulotech.first_spring_app.controller;

import com.paulotech.first_spring_app.domain.User;
import com.paulotech.first_spring_app.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {

    @Autowired
    private HelloWorldService helloWorldService;

    @GetMapping
    public String helloWorld() {
        return helloWorldService.helloWorld("paulotech");
    }

    @PostMapping("/post")
    public String helloWorldPost(@RequestBody User body) {
        return "hello world" + body.getName();
    }

    @PostMapping("/{id}")
    public String helloWorldPost(@PathVariable("id") String id, @RequestBody User body) {
        return "hello world" + body.getName() + id;
    }

    @PostMapping("/{id}")
    public String helloWorldPost(@PathVariable("id") String id, @RequestParam(value = "filter", defaultValue = "nenhum") String filter, @RequestBody User body) {
        return "hello world" + id;
    }
}

