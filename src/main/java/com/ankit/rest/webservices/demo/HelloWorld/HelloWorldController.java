package com.ankit.rest.webservices.demo.HelloWorld;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello-world")
    public String HelloSpringWorld(){
        return "Hello let's try to learn spring for fun";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorld HelloWorldBean(){
        return new HelloWorld("Hi Ankit");
    }

}
