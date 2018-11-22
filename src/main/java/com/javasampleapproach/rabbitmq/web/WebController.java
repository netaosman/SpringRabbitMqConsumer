package com.javasampleapproach.rabbitmq.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest Api - web controller:
 * Managing and mapping the http requests
 */
@RestController
public class WebController {

    @RequestMapping("/")
    public String index() {
        return "Hello from consumer";
    }
}
