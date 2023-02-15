package com.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Communication {
    @Autowired
    private RestTemplate restTemplate;
    private final String URL = "";

    public List<Object> getAllObject;

//    ResponseEntity<List<Object>> responseEntity =
//            restTemplate.exchange(URL, HttpMethod.GET, null
//                    ,new  ParameterizedTypeReference<List<Object>>(){});
}
