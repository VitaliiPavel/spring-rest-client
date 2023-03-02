package com.spring.rest;

import com.spring.rest.constants.CommandTypes;
import com.spring.rest.constants.RequestParameters;
import com.spring.rest.constants.TransactionTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Component
public class Communication {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${merchant.handler.url}")
    private String merchantHandlerURL;

    @Value("${client.handler.url}")
    private String clientHandlerURL;

    public ResponseEntity<String> registerSmsTransaction(int amount, int currency, String clientIpAdr, String language, String description) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(merchantHandlerURL)

                .queryParam(RequestParameters.COMMAND, CommandTypes.REGISTER_SMS_TRANSACTION)
                .queryParam(RequestParameters.AMOUNT, String.valueOf(amount))
                .queryParam(RequestParameters.CURRENCY, String.valueOf(currency))
                .queryParam(RequestParameters.CLIENT_IP_ADDR, clientIpAdr)
                .queryParam(RequestParameters.LANGUAGE, language)
                .queryParam(RequestParameters.DESCRIPTION, description)
                .queryParam(RequestParameters.MSG_TYPE, TransactionTypes.SMS);

        return performRequest(builder.build().toUriString());
    }

    public ResponseEntity<String> getTransactionResult(String transId, String clientIpAdr) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(merchantHandlerURL)

                .queryParam(RequestParameters.COMMAND, CommandTypes.GET_TRANSACTION_RESULT)
                .queryParam(RequestParameters.TRANS_ID, transId)
                .queryParam(RequestParameters.CLIENT_IP_ADDR, clientIpAdr);

        return performRequest(builder.build().toUriString());
    }

    public ResponseEntity<String> registerDmsTransaction(String clientIpAdr, int amount, int currency, String description, String language) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(merchantHandlerURL)

                .queryParam(RequestParameters.COMMAND, CommandTypes.REGISTER_DMS_TRANSACTION)
                .queryParam(RequestParameters.CLIENT_IP_ADDR, clientIpAdr)
                .queryParam(RequestParameters.AMOUNT, String.valueOf(amount))
                .queryParam(RequestParameters.CURRENCY, String.valueOf(currency))
                .queryParam(RequestParameters.DESCRIPTION, description)
                .queryParam(RequestParameters.LANGUAGE, language)
                .queryParam(RequestParameters.MSG_TYPE, TransactionTypes.DMS);

        return performRequest(builder.build().toUriString());
    }

    public ResponseEntity<String> makeDmsTransaction(String clientIpAdr, String transId, int amount, int currency, String description, String language) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(merchantHandlerURL)

                .queryParam(RequestParameters.COMMAND, CommandTypes.MAKE_DMS_TRANSACTION)
                .queryParam(RequestParameters.TRANS_ID, transId)
                .queryParam(RequestParameters.AMOUNT, String.valueOf(amount))
                .queryParam(RequestParameters.CURRENCY, String.valueOf(currency))
                .queryParam(RequestParameters.CLIENT_IP_ADDR, clientIpAdr)
                .queryParam(RequestParameters.LANGUAGE, language)
                .queryParam(RequestParameters.DESCRIPTION, description)
                .queryParam(RequestParameters.MSG_TYPE, TransactionTypes.DMS);

        return performRequest(builder.build().toUriString());
    }

    public ResponseEntity<String> revertTransaction(String transId, int amount, String suspectedFraud) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(merchantHandlerURL)

                .queryParam(RequestParameters.COMMAND, CommandTypes.REVERT_TRANSACTION)
                .queryParam(RequestParameters.TRANS_ID, transId)
                .queryParam(RequestParameters.AMOUNT, String.valueOf(amount))
                .queryParam(RequestParameters.SUSPECTED_FRAUD, suspectedFraud);
        return performRequest(builder.build().toUriString());
    }

    public ResponseEntity<String> closeDay() {

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(merchantHandlerURL)
                .queryParam(RequestParameters.COMMAND, CommandTypes.CLOSE_DAY);

        return performRequest(builder.build().toUriString());

    }

    public ResponseEntity<String> registerRegularSmsTransaction(int amount, int currency, String clientIpAdr, String language, String description, String billerClientId, String perspayeeExpiry, String perspayeeGen, String perspayeeOverwrite) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(merchantHandlerURL)

                .queryParam(RequestParameters.COMMAND, CommandTypes.REGISTER_REGULAR_SMS_TRANSACTION)
                .queryParam(RequestParameters.AMOUNT, String.valueOf(amount))
                .queryParam(RequestParameters.CURRENCY, String.valueOf(currency))
                .queryParam(RequestParameters.CLIENT_IP_ADDR, clientIpAdr)
                .queryParam(RequestParameters.LANGUAGE, language)
                .queryParam(RequestParameters.DESCRIPTION, description)
                .queryParam(RequestParameters.BILLER_CLIENT_ID, billerClientId)
                .queryParam(RequestParameters.PERSPAYEE_EXPIRY, perspayeeExpiry)
                .queryParam(RequestParameters.PERSPAYEE_GEN, perspayeeGen)
                .queryParam(RequestParameters.PERSPAYEE_OVERWRITE, perspayeeOverwrite)
                .queryParam(RequestParameters.MSG_TYPE, TransactionTypes.SMS);
        return performRequest(builder.build().toUriString());
    }

    public ResponseEntity<String> registerRegularDmsTransaction(int amount, int currency, String clientIpAdr, String language, String description, String billerClientId, String perspayeeExpiry, String perspayeeGen, String perspayeeOverwrite) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(merchantHandlerURL)

                .queryParam(RequestParameters.COMMAND, CommandTypes.REGISTER_REGULAR_DMS_TRANSACTION)
                .queryParam(RequestParameters.AMOUNT, String.valueOf(amount))
                .queryParam(RequestParameters.CURRENCY, String.valueOf(currency))
                .queryParam(RequestParameters.CLIENT_IP_ADDR, clientIpAdr)
                .queryParam(RequestParameters.LANGUAGE, language)
                .queryParam(RequestParameters.DESCRIPTION, description)
                .queryParam(RequestParameters.BILLER_CLIENT_ID, billerClientId)
                .queryParam(RequestParameters.PERSPAYEE_EXPIRY, perspayeeExpiry)
                .queryParam(RequestParameters.PERSPAYEE_GEN, perspayeeGen)
                .queryParam(RequestParameters.PERSPAYEE_OVERWRITE, perspayeeOverwrite)
                .queryParam(RequestParameters.MSG_TYPE, TransactionTypes.DMS);

        return performRequest(builder.build().toUriString());
    }

    public ResponseEntity<String> registerRegularAuthTransaction(int amount, int currency, String clientIpAdr, String language, String description, String billerClientId, String perspayeeExpiry, String perspayeeGen) {

        Map<String, String> params = new HashMap<>();

                params.put(RequestParameters.COMMAND, CommandTypes.REGISTER_REGULAR_TRANSACTION);
                params.put(RequestParameters.AMOUNT, String.valueOf(amount));
                params.put(RequestParameters.CURRENCY, String.valueOf(currency));
                params.put(RequestParameters.CLIENT_IP_ADDR, clientIpAdr);
                params.put(RequestParameters.LANGUAGE, language);
                params.put(RequestParameters.DESCRIPTION, description);
                params.put(RequestParameters.BILLER_CLIENT_ID, billerClientId);
                params.put(RequestParameters.PERSPAYEE_EXPIRY, perspayeeExpiry);
                params.put(RequestParameters.PERSPAYEE_GEN, perspayeeGen);
                params.put(RequestParameters.MSG_TYPE, TransactionTypes.AUTH);

        return performRequest(merchantHandlerURL, params);
    }

    public ResponseEntity<String> makeTransaction(int amount, int currency, String clientIpAdr, String language, String description, String billerClientId) {
        Map<String, String> params = new HashMap<>();

        params.put(RequestParameters.COMMAND, CommandTypes.MAKE_TRANSACTION);
        params.put(RequestParameters.AMOUNT, String.valueOf(amount));
        params.put(RequestParameters.CURRENCY, String.valueOf(currency));
        params.put(RequestParameters.CLIENT_IP_ADDR, clientIpAdr);
        params.put(RequestParameters.LANGUAGE, language);
        params.put(RequestParameters.DESCRIPTION, description);
        params.put(RequestParameters.BILLER_CLIENT_ID, billerClientId);

        return performRequest(merchantHandlerURL, params);
    }

    public ResponseEntity<String> deleteTransaction(String billerClientId) {
        Map<String, String> params = new HashMap<>();
        params.put(RequestParameters.COMMAND, CommandTypes.DELETE_TRANSACTION);
        params.put(RequestParameters.BILLER_CLIENT_ID, billerClientId);
        return performRequest(merchantHandlerURL, params);
    }

    public ResponseEntity<String> performRequest(String url, Map<String, String> params) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        for (Map.Entry<String, String> entry : params.entrySet()) {
            builder.queryParam(entry.getKey(), entry.getValue());
        }
        return restTemplate.exchange(
                builder.build().toUriString(),
                HttpMethod.POST,
                requestEntity,
                String.class
        );
    }
}
