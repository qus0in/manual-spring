package org.example.manualspring.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService implements IHelloService {

    public String greet(String name) {
        return "Hello " + name;
    }
}
