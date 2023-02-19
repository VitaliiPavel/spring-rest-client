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

    public Map registerSmsTransaction(double amount,int currency, String client_ip_adr,
                                 String language, String description){
        HttpHeaders headers = new HttpHeaders();
        HttpEntity requestEntity = new HttpEntity<>(headers);

        Map<String, String> uriVariables = new HashMap<>();

        uriVariables.put("command", "v");
        uriVariables.put("amount", String.valueOf(amount));
        uriVariables.put("currency", String.valueOf(currency));
        uriVariables.put("client_ip_adr", client_ip_adr);
        uriVariables.put("language", language);
        uriVariables.put("description", description);
        uriVariables.put("msg_type", "SMS");

        ResponseEntity<Map> response = restTemplate.exchange(
                MAIB_TEST_BASE_URI,
                HttpMethod.POST,
                requestEntity,
                Map.class,
                uriVariables
        );
        return response.getBody();
    }

    public Map getTransactionResult(String trans_id, String client_ip_adr){
        HttpHeaders headers = new HttpHeaders();
        HttpEntity requestEntity = new HttpEntity<>(headers);

        Map<String, String> uriVariables = new HashMap<>();

        uriVariables.put("command", "c");
        uriVariables.put("trans_id", trans_id);
        uriVariables.put("client_ip_adr", client_ip_adr);

        ResponseEntity<Map> response = restTemplate.exchange(
                MAIB_TEST_BASE_URI,
                HttpMethod.POST,
                requestEntity,
                Map.class,
                uriVariables
        );
        return response.getBody();
    }

    public Map  registerDmsTransaction(String client_ip_adr, double amount, int currency,
                                         String description, String language){
        HttpHeaders headers = new HttpHeaders();
        HttpEntity requestEntity = new HttpEntity<>(headers);

        Map<String, String> uriVariables = new HashMap<>();

        uriVariables.put("command", "a");
        uriVariables.put("client_ip_adr", client_ip_adr);
        uriVariables.put("amount", String.valueOf(amount));
        uriVariables.put("currency", String.valueOf(currency));
        uriVariables.put("description", description);
        uriVariables.put("language", language);
        uriVariables.put("msg_type", "DMS");

        ResponseEntity<Map> response = restTemplate.exchange(
                MAIB_TEST_BASE_URI,
                HttpMethod.POST,
                requestEntity,
                Map.class,
                uriVariables
        );
        return response.getBody();
    }
    public Map makeDmsTransaction(String client_ip_adr,String trans_id, double amount, int currency,
                                         String description, String language){
        HttpHeaders headers = new HttpHeaders();
        HttpEntity requestEntity = new HttpEntity<>(headers);

        Map<String, String> uriVariables = new HashMap<>();

        uriVariables.put("command", "t");
        uriVariables.put("trans_id", trans_id);
        uriVariables.put("client_ip_adr", client_ip_adr);
        uriVariables.put("amount", String.valueOf(amount));
        uriVariables.put("currency", String.valueOf(currency));
        uriVariables.put("description", description);
        uriVariables.put("language", language);
        uriVariables.put("msg_type", "DMS");

        ResponseEntity<Map> response = restTemplate.exchange(
                MAIB_TEST_BASE_URI,
                HttpMethod.POST,
                requestEntity,
                Map.class,
                uriVariables
        );
        return response.getBody();
    }
    public Map revertTransaction(String trans_id, double amount, String suspected_fraud){
        HttpHeaders headers = new HttpHeaders();
        HttpEntity requestEntity = new HttpEntity<>(headers);

        Map<String, String> uriVariables = new HashMap<>();

        uriVariables.put("command", "r");
        uriVariables.put("trans_id", trans_id);
        uriVariables.put("amount", String.valueOf(amount));
        uriVariables.put("suspected_fraud", suspected_fraud);

        ResponseEntity<Map> response = restTemplate.exchange(
                MAIB_TEST_BASE_URI,
                HttpMethod.POST,
                requestEntity,
                Map.class,
                uriVariables
        );
        return response.getBody();
    }
    public Map closeDay(){
        HttpHeaders headers = new HttpHeaders();
        HttpEntity requestEntity = new HttpEntity<>(headers);

        Map<String, String> uriVariables = new HashMap<>();

        uriVariables.put("command", "b");

        ResponseEntity<Map> response = restTemplate.exchange(
                MAIB_TEST_BASE_URI,
                HttpMethod.POST,
                requestEntity,
                Map.class,
                uriVariables
        );
        return response.getBody();
    }
    public Map registerRegularTransaction(double amount,int currency, String client_ip_adr,
                                      String language, String description, String biller_client_id,
                                          String perspayee_expiry, String perspayee_gen,
                                          String msg_type, String command, String perspayee_overwrite){
        HttpHeaders headers = new HttpHeaders();
        HttpEntity requestEntity = new HttpEntity<>(headers);

        Map<String, String> uriVariables = new HashMap<>();

        uriVariables.put("command", command);
        uriVariables.put("amount", String.valueOf(amount));
        uriVariables.put("currency", String.valueOf(currency));
        uriVariables.put("client_ip_adr", client_ip_adr);
        uriVariables.put("language", language);
        uriVariables.put("description", description);
        uriVariables.put("biller_client_id", biller_client_id);
        uriVariables.put("perspayee_expiry",perspayee_expiry);
        uriVariables.put("perspayee_gen",perspayee_gen);
        uriVariables.put("msg_type", msg_type);
        uriVariables.put("perspayee_overwrite", perspayee_overwrite);

        ResponseEntity<Map> response = restTemplate.exchange(
                MAIB_TEST_BASE_URI,
                HttpMethod.POST,
                requestEntity,
                Map.class,
                uriVariables
        );
        return response.getBody();
    }

    public Map registerRegularTransaction(double amount,int currency, String client_ip_adr,
                                          String language, String description, String biller_client_id,
                                          String perspayee_expiry, String perspayee_gen){
        HttpHeaders headers = new HttpHeaders();
        HttpEntity requestEntity = new HttpEntity<>(headers);

        Map<String, String> uriVariables = new HashMap<>();

        uriVariables.put("command", "p");
        uriVariables.put("amount", String.valueOf(amount));
        uriVariables.put("currency", String.valueOf(currency));
        uriVariables.put("client_ip_adr", client_ip_adr);
        uriVariables.put("language", language);
        uriVariables.put("description", description);
        uriVariables.put("biller_client_id", biller_client_id);
        uriVariables.put("perspayee_expiry",perspayee_expiry);
        uriVariables.put("perspayee_gen",perspayee_gen);
        uriVariables.put("msg_type", "AUTH");

        ResponseEntity<Map> response = restTemplate.exchange(
                MAIB_TEST_BASE_URI,
                HttpMethod.POST,
                requestEntity,
                Map.class,
                uriVariables
        );
        return response.getBody();
    }

    public Map makeTransaction(double amount,int currency, String client_ip_adr,
                                          String language, String description, String biller_client_id){
        HttpHeaders headers = new HttpHeaders();
        HttpEntity requestEntity = new HttpEntity<>(headers);

        Map<String, String> uriVariables = new HashMap<>();

        uriVariables.put("command", "e");
        uriVariables.put("amount", String.valueOf(amount));
        uriVariables.put("currency", String.valueOf(currency));
        uriVariables.put("client_ip_adr", client_ip_adr);
        uriVariables.put("language", language);
        uriVariables.put("description", description);
        uriVariables.put("biller_client_id", biller_client_id);

        ResponseEntity<Map> response = restTemplate.exchange(
                MAIB_TEST_BASE_URI,
                HttpMethod.POST,
                requestEntity,
                Map.class,
                uriVariables
        );
        return response.getBody();
    }
    public Map deleteTransaction( String biller_client_id){
        HttpHeaders headers = new HttpHeaders();
        HttpEntity requestEntity = new HttpEntity<>(headers);

        Map<String, String> uriVariables = new HashMap<>();

        uriVariables.put("command", "x");
        uriVariables.put("biller_client_id", biller_client_id);

        ResponseEntity<Map> response = restTemplate.exchange(
                MAIB_TEST_BASE_URI,
                HttpMethod.POST,
                requestEntity,
                Map.class,
                uriVariables
        );
        return response.getBody();
    }

}
