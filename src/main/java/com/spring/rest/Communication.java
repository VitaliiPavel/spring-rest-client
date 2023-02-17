package com.spring.rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;


@Component
public class Communication {
    @Autowired
    private RestTemplate restTemplate;

    private final String MAIB_TEST_REDIRECT_URL = "https://maib.ecommerce.md:21443/ecomm/ClientHandler";

    private final String MAIB_TEST_BASE_URI = "https://maib.ecommerce.md:21440/ecomm/MerchantHandler";

    public String getTransaction(){

        HttpHeaders headers = new HttpHeaders();
        HttpEntity requestEntity = new HttpEntity<>(headers);

        Map<String, String> uriVariables = new HashMap<>();

        uriVariables.put("command", "v");
        uriVariables.put("amount", "400");
        uriVariables.put("currency", "498");
        uriVariables.put("client_ip_adr", "127.0.0.1");
        uriVariables.put("language", "en");
        uriVariables.put("description", "postman");
        uriVariables.put("msg_type", "SMS");

        ResponseEntity<String> response = restTemplate.exchange(
                MAIB_TEST_BASE_URI,
                HttpMethod.POST,
                requestEntity,
                String.class,
                uriVariables
        );

        return response.getBody();
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
