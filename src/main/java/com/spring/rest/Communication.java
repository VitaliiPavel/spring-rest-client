package com.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;



@Component
public class Communication {
    @Autowired
    private RestTemplate restTemplate;
    private final String MAIB_LIVE_REDIRECT_URL = "https://maib.ecommerce.md:443/ecomm01/ClientHandler";
    private final String MAIB_LIVE_BASE_URI = "https://maib.ecommerce.md:11440/ecomm01/MerchantHandler";
    private final String MAIB_TEST_REDIRECT_URL = "https://maib.ecommerce.md:21443/ecomm/ClientHandler";
    private final String MAIB_TEST_BASE_URI = "https://maib.ecommerce.md:21440/ecomm/MerchantHandler";
}
