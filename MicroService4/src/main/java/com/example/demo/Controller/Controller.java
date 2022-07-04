package com.example.demo.Controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/userdetail1")
    public String method1(){
        LOG.info("I am inside method1 of 4th microservice.....Method1");

        int n =(int)(Math.random()*10);
        String baseUrl = "http://localhost:8085/notification";
        String response = (String) restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class).getBody();
        LOG.info("The response received by method1 is " + response);
        return response;


    }

    @GetMapping("/userdetail2")
    public String method2(){
        LOG.info("I am inside method1 of 4th microservice......Method2");
        int n =(int)(Math.random()*10);
        String baseUrl = "http://localhost:8085/notification";
        String response = (String) restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class).getBody();
        LOG.info("The response received by method1 is " + response);
        return response;

    }

    @GetMapping("/userdetail3")
    public String method3(){
        LOG.info("I am inside method1 of 4th microservice.....Method3");
        int n =(int)(Math.random()*10);
            String baseUrl = "http://localhost:8085/notification";
            String response = (String) restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class).getBody();
            LOG.info("The response received by method1 is " + response);
            return response;

    }

    @PostMapping(value="/userDetail",consumes = "application/json", produces = "application/json")
    public String postmethod1(){
        String response =" post method in microservice 4 for userDetail";
        return response;
    }




}
