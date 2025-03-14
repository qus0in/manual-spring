package org.example.manualspring.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.manualspring.service.HelloService;
import org.example.manualspring.service.IHelloService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;

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
    public String getHello(@RequestParam(name = "name") String name,
                           HttpServletRequest request,
                           HttpServletResponse response) throws UnsupportedEncodingException {
        // 해결 :)
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=UTF-8");
        // 자 이걸 필터로 하면 되는데...(?) 부트는 알아서 잘해주는데... 이런...
        return helloService.greet("Hello My name is %s".formatted(name));
    }
}
