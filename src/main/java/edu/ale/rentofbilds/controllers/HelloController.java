package edu.ale.rentofbilds.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    String sayHello() {

        String string = "<h1>Hello From Controller !</h1>";

        return string;
    }
}
