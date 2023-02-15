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

    private final String MAIB_TEST_REDIRECT_URL = "https://maib.ecommerce.md:21443/ecomm/ClientHandler";

    private final String MAIB_TEST_BASE_URI = "https://maib.ecommerce.md:21440/ecomm/MerchantHandler";

    public Object registerTransaction(){

        ResponseEntity<Object> responseEntity =
                restTemplate.exchange(MAIB_TEST_BASE_URI, HttpMethod.GET, null
                    ,new  ParameterizedTypeReference<Object>(){});
        return null;
    }

    public Object requestTransactionStatus(){
        return null;
    }

    public Object cancelTransaction(){
        return null;
    }

    public Object closeBusinessDay(){
        return null;
    }

}
