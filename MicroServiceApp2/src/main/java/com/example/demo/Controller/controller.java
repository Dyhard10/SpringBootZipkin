package com.example.demo.Controller;

import lombok.extern.java.Log;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class controller {
    @Autowired
    RestTemplate restTemplate;
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());
    @GetMapping("/optionCheck")
    public String payment(){
        LOG.info("I am inside bankservice inside of 2nd microservice");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject personJsonObject = new JSONObject();
        personJsonObject.put("name","deepak");
        personJsonObject.put("bankname","sbi");
        HttpEntity<String> request = new HttpEntity<String>(personJsonObject.toString(), headers);
        String createPersonUrl="http://localhost:8084/userDetail";

        String baseUrl1 = "http://localhost:8083/bank1/?user={user}&bankname={bankname}";

        //LOG.info("The response received by method1 is " + response1);

        String baseUrl2 = "http://localhost:8083/bank2";

        //LOG.info("The response received by method1 is " + response2);

        String baseUrl3 = "http://localhost:8083/bank3";
        String createPersonUrl2 = "http://localhost:8080/userData";
        String createPersonUrl3 = "http://localhost:8087/GupshupApi";

        String response1 = (String) restTemplate.exchange(baseUrl1, HttpMethod.GET, null, String.class,"deepakyadav","HDFCbhi").getBody();
        String response2 = (String) restTemplate.exchange(baseUrl2, HttpMethod.GET, null, String.class).getBody();
        String response3 = (String) restTemplate.exchange(baseUrl3, HttpMethod.GET, null, String.class).getBody();

        String personResultAsJsonStr = restTemplate.postForObject(createPersonUrl, request, String.class);
        String personResultAsJsonStr2 = restTemplate.postForObject(createPersonUrl2, request, String.class);
        String personResultAsJsonStr3 = restTemplate.postForObject(createPersonUrl3, request, String.class);



        String response = response1+response2+response3+personResultAsJsonStr;
        LOG.info("The response received by method1 is " + response);
        return response;
    }

}
