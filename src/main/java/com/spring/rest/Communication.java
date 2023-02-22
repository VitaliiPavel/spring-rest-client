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

        return performRequest(builder.build().encode().toUriString());
    }

    public ResponseEntity<String> getTransactionResult(String transId, String clientIpAdr) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(merchantHandlerURL)

                .queryParam(RequestParameters.COMMAND, CommandTypes.GET_TRANSACTION_RESULT)
                .queryParam(RequestParameters.TRANS_ID, transId)
                .queryParam(RequestParameters.CLIENT_IP_ADDR, clientIpAdr);

        return performRequest(builder.build().encode().toUriString());
    }

    public ResponseEntity<String> registerDmsTransaction(String clientIpAdr, double amount, int currency, String description, String language) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(merchantHandlerURL)

                .queryParam(RequestParameters.COMMAND, CommandTypes.REGISTER_DMS_TRANSACTION)
                .queryParam(RequestParameters.CLIENT_IP_ADDR, clientIpAdr)
                .queryParam(RequestParameters.AMOUNT, String.valueOf(amount))
                .queryParam(RequestParameters.CURRENCY, String.valueOf(currency))
                .queryParam(RequestParameters.DESCRIPTION, description)
                .queryParam(RequestParameters.LANGUAGE, language)
                .queryParam(RequestParameters.MSG_TYPE, TransactionTypes.DMS);

        return performRequest(builder.build().encode().toUriString());
    }

    public ResponseEntity<String> makeDmsTransaction(String clientIpAdr, String transId, double amount, int currency, String description, String language) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(merchantHandlerURL)

                .queryParam(RequestParameters.COMMAND, CommandTypes.MAKE_DMS_TRANSACTION)
                .queryParam(RequestParameters.TRANS_ID, transId)
                .queryParam(RequestParameters.AMOUNT, String.valueOf(amount))
                .queryParam(RequestParameters.CURRENCY, String.valueOf(currency))
                .queryParam(RequestParameters.CLIENT_IP_ADDR, clientIpAdr)
                .queryParam(RequestParameters.LANGUAGE, language)
                .queryParam(RequestParameters.DESCRIPTION, description)
                .queryParam(RequestParameters.MSG_TYPE, TransactionTypes.DMS);

        return performRequest(builder.build().encode().toUriString());
    }

    public ResponseEntity<String> revertTransaction(String transId, double amount, String suspectedFraud) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(merchantHandlerURL)

                .queryParam(RequestParameters.COMMAND, CommandTypes.REVERT_TRANSACTION)
                .queryParam(RequestParameters.TRANS_ID, transId)
                .queryParam(RequestParameters.AMOUNT, String.valueOf(amount))
                .queryParam(RequestParameters.SUSPECTED_FRAUD, suspectedFraud);
        return performRequest(builder.build().encode().toUriString());
    }

    public ResponseEntity<String> closeDay() {

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(merchantHandlerURL)
                .queryParam(RequestParameters.COMMAND, CommandTypes.CLOSE_DAY);

        return performRequest(builder.build().encode().toUriString());

    }

    public ResponseEntity<String> registerRegularSmsTransaction(double amount, int currency, String clientIpAdr, String language, String description, String billerClientId, String perspayeeExpiry, String perspayeeGen, String perspayeeOverwrite) {

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
        return performRequest(builder.build().encode().toUriString());
    }

    public ResponseEntity<String> registerRegularDmsTransaction(double amount, int currency, String clientIpAdr, String language, String description, String billerClientId, String perspayeeExpiry, String perspayeeGen, String perspayeeOverwrite) {

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

        return performRequest(builder.build().encode().toUriString());
    }

    public ResponseEntity<String> registerRegularTransaction(double amount, int currency, String clientIpAdr, String language, String description, String billerClientId, String perspayeeExpiry, String perspayeeGen) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(merchantHandlerURL)

                .queryParam(RequestParameters.COMMAND, CommandTypes.REGISTER_REGULAR_TRANSACTION)
                .queryParam(RequestParameters.AMOUNT, String.valueOf(amount))
                .queryParam(RequestParameters.CURRENCY, String.valueOf(currency))
                .queryParam(RequestParameters.CLIENT_IP_ADDR, clientIpAdr)
                .queryParam(RequestParameters.LANGUAGE, language)
                .queryParam(RequestParameters.DESCRIPTION, description)
                .queryParam(RequestParameters.BILLER_CLIENT_ID, billerClientId)
                .queryParam(RequestParameters.PERSPAYEE_EXPIRY, perspayeeExpiry)
                .queryParam(RequestParameters.PERSPAYEE_GEN, perspayeeGen)
                .queryParam(RequestParameters.MSG_TYPE, TransactionTypes.AUTH);

        return performRequest(builder.build().encode().toUriString());
    }

    public ResponseEntity<String> makeTransaction(double amount, int currency, String clientIpAdr, String language, String description, String billerClientId) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(merchantHandlerURL)

                .queryParam(RequestParameters.COMMAND, CommandTypes.MAKE_TRANSACTION)
                .queryParam(RequestParameters.AMOUNT, String.valueOf(amount))
                .queryParam(RequestParameters.CURRENCY, String.valueOf(currency))
                .queryParam(RequestParameters.CLIENT_IP_ADDR, clientIpAdr)
                .queryParam(RequestParameters.LANGUAGE, language)
                .queryParam(RequestParameters.DESCRIPTION, description)
                .queryParam(RequestParameters.BILLER_CLIENT_ID, billerClientId);

        return performRequest(builder.build().encode().toUriString());
    }

    public ResponseEntity<String > deleteTransaction(String billerClientId) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(merchantHandlerURL)

                .queryParam(RequestParameters.COMMAND, CommandTypes.DELETE_TRANSACTION)
                .queryParam(RequestParameters.BILLER_CLIENT_ID, billerClientId);

        return performRequest(builder.build().encode().toUriString());
    }

    public ResponseEntity<String> performRequest(String url) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        return restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                String.class,
                Map.class
        );
    }
}
