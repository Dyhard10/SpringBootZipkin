package com.example.demo.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class controller {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());
    @Autowired
    RestTemplate restTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();


    // Passanger Management
    @GetMapping("/client")
    public String method1(){
        LOG.info("I am inside method1 of 1st microservice");
        String baseUrl = "http://localhost:8082/optionCheck";


        //////////
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject personJsonObject = new JSONObject();
        personJsonObject.put("name","deepak");
        personJsonObject.put("bankname","sbi");
        HttpEntity<String> request = new HttpEntity<String>(personJsonObject.toString(), headers);
        String createPersonUrl="http://localhost:8083/bank31";
        String personResultAsJsonStr = restTemplate.postForObject(createPersonUrl, request, String.class);
        String response1 = (String) restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class).getBody();

        LOG.info("The response received by method1 is " + response1 + " "+personResultAsJsonStr);
        //LOG.info("The response received by method1 is " + response1);
        String response = response1 + personResultAsJsonStr;
        //String response = response1 ;
        //////////
        return response;

    }

}
