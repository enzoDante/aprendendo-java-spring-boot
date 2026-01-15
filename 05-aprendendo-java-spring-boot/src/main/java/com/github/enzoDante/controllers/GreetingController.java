package com.github.enzoDante.controllers;

import com.github.enzoDante.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %S!";
    private final AtomicLong counter = new AtomicLong();

    // http://localhost:8080/greeting?name=Enzo
    @RequestMapping("/greeting") // existe alternativas melhores que esse @, mas ele é pra código legado
    // /greeting endpoint
    public Greeting greeting(
            @RequestParam(value = "name", defaultValue = "world")
            String name) {
        return  new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
