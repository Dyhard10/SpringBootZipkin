package com.example.demo.Controller;

import com.example.demo.Model.UserDetail;
import com.example.demo.Service.userService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class controller {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());
    @Autowired
    RestTemplate restTemplate;
    @GetMapping("/bank1")
    public String method1(@RequestParam String user,@RequestParam String bankname){
        LOG.info("In the 3rd Microservice.......Method1");
        String baseUrl = "http://localhost:8084/userdetail1";
        //System.out.println("yoo "+ user + bankname);
        String response = (String) restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class).getBody();
        LOG.info("The response received by method1 is " + response +" " + user + bankname);
        return response;
    }

    @GetMapping("/bank2")
    public String method2(){
        LOG.info("In the 3rd Microservice......Method2");
        String baseUrl = "http://localhost:8084/userdetail2";
        String response = (String) restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class).getBody();
        LOG.info("The response received by method2 is " + response);
        return response;
    }
    @GetMapping("/bank3")
    public String method3(){
        LOG.info("In the 3rd Microservice..... Method3");
        String baseUrl = "http://localhost:8084/userdetail3";
        String response = (String) restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class).getBody();
        LOG.info("The response received by method3 is " + response);
        return response;
    }

    @PostMapping(value="/bank3",consumes = "application/json", produces = "application/json")
    public String userDetail(@RequestBody UserDetail userDetail){
        String response1 = "Post Request done";
        String baseUrl = "http://localhost:8081/client";
        String response2 = (String) restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class).getBody();
        LOG.info("The response received by method1 is " + response1 + response2);
        String response=response1+response2;
        return response;
    }
    @PostMapping(value="/bank31",consumes = "application/json", produces = "application/json")
    public String userDetai2(@RequestBody UserDetail userDetail){
        String response = "Post Request done";
        return response;
    }
}
