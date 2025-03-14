package org.example.manualspring.controller;

import org.example.manualspring.service.HelloService;
import org.example.manualspring.service.IHelloService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // controller -> component
@RequestMapping("/hello") // -> 주소에 접근
public class HelloController {
    private final IHelloService helloService;
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Hello World";
    }

    @RequestMapping("/greet")
    @ResponseBody
//    public String getHello(@RequestParam(name = "name") String name) {
    public String getHello(@RequestParam(name = "name") String name) {
        System.out.println(name);
        return helloService.greet("Hello My name is %s".formatted(name));
    }
}
