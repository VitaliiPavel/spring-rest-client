package com.spring.rest;

import com.spring.rest.constants.CommandTypes;
import com.spring.rest.constants.RequestParameters;
import com.spring.rest.dto.CloseBusinessDayDTO;
import com.spring.rest.dto.DmsTransactionDTO;
import com.spring.rest.dto.ResponseDTO;
import com.spring.rest.dto.TransactionStatusDTO;
import com.spring.rest.enums.TransactionTypes;
import com.spring.rest.mapper.ResponseMapper;
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

    public ResponseDTO registerSmsTransaction(int amount, int currency, String clientIpAdr, String language, String description) {

        Map<String, String> params = new HashMap<>();
        params.put(RequestParameters.COMMAND, CommandTypes.REGISTER_SMS_TRANSACTION);
        params.put(RequestParameters.AMOUNT, String.valueOf(amount));
        params.put(RequestParameters.CURRENCY, String.valueOf(currency));
        params.put(RequestParameters.CLIENT_IP_ADDR, clientIpAdr);
        params.put(RequestParameters.LANGUAGE, language);
        params.put(RequestParameters.DESCRIPTION, description);
        params.put(RequestParameters.MSG_TYPE, TransactionTypes.SMS.toString());

        ResponseEntity<String> response = performRequest(merchantHandlerURL, params);
        return ResponseMapper.mapResponseToResponseDTO(response.getBody());
    }

    public TransactionStatusDTO getTransactionResult(String transId, String clientIpAdr) {

        Map<String, String> params = new HashMap<>();
        params.put(RequestParameters.COMMAND, CommandTypes.GET_TRANSACTION_RESULT);
        params.put(RequestParameters.TRANS_ID, transId);
        params.put(RequestParameters.CLIENT_IP_ADDR, clientIpAdr);

        ResponseEntity<String> response = performRequest(merchantHandlerURL, params);
        return ResponseMapper.mapResponseToTransactionStatusDTO(response.getBody());
    }

    public ResponseDTO registerDmsTransaction(String clientIpAdr, int amount, int currency, String description, String language) {

        Map<String, String> params = new HashMap<>();
        params.put(RequestParameters.COMMAND, CommandTypes.REGISTER_DMS_TRANSACTION);
        params.put(RequestParameters.CLIENT_IP_ADDR, clientIpAdr);
        params.put(RequestParameters.AMOUNT, String.valueOf(amount));
        params.put(RequestParameters.CURRENCY, String.valueOf(currency));
        params.put(RequestParameters.DESCRIPTION, description);
        params.put(RequestParameters.LANGUAGE, language);
        params.put(RequestParameters.MSG_TYPE, TransactionTypes.DMS.toString());

        ResponseEntity<String> response = performRequest(merchantHandlerURL, params);
        return ResponseMapper.mapResponseToResponseDTO(response.getBody());
    }

    public DmsTransactionDTO makeDmsTransaction(String clientIpAdr, String transId, int amount, int currency, String description, String language) {

        Map<String, String> params = new HashMap<>();
        params.put(RequestParameters.COMMAND, CommandTypes.MAKE_DMS_TRANSACTION);
        params.put(RequestParameters.TRANS_ID, transId);
        params.put(RequestParameters.AMOUNT, String.valueOf(amount));
        params.put(RequestParameters.CURRENCY, String.valueOf(currency));
        params.put(RequestParameters.CLIENT_IP_ADDR, clientIpAdr);
        params.put(RequestParameters.LANGUAGE, language);
        params.put(RequestParameters.DESCRIPTION, description);
        params.put(RequestParameters.MSG_TYPE, TransactionTypes.DMS.toString());

        ResponseEntity<String> response = performRequest(merchantHandlerURL, params);
        return ResponseMapper.mapResponseToDmsTransactionDTO(response.getBody());
    }

    public ResponseDTO revertTransaction(String transId, int amount, String suspectedFraud) {

        Map<String, String> params = new HashMap<>();
        params.put(RequestParameters.COMMAND, CommandTypes.REVERT_TRANSACTION);
        params.put(RequestParameters.TRANS_ID, transId);
        params.put(RequestParameters.AMOUNT, String.valueOf(amount));
        params.put(RequestParameters.SUSPECTED_FRAUD, suspectedFraud);
        ResponseEntity<String> response = performRequest(merchantHandlerURL, params);
        return ResponseMapper.mapResponseToResponseDTO(response.getBody());
    }

    public CloseBusinessDayDTO closeDay() {

        Map<String, String> params = new HashMap<>();
        params.put(RequestParameters.COMMAND, CommandTypes.CLOSE_DAY);
        ResponseEntity<String> response = performRequest(merchantHandlerURL, params);
        return ResponseMapper.mapResponseToCloseDayDTO(response.getBody());
    }

    public ResponseDTO registerRegularSmsTransaction(int amount, int currency, String clientIpAdr, String language, String description, String billerClientId, String perspayeeExpiry, String perspayeeGen, String perspayeeOverwrite) {

        Map<String, String> params = new HashMap<>();
        params.put(RequestParameters.COMMAND, CommandTypes.REGISTER_REGULAR_SMS_TRANSACTION);
        params.put(RequestParameters.AMOUNT, String.valueOf(amount));
        params.put(RequestParameters.CURRENCY, String.valueOf(currency));
        params.put(RequestParameters.CLIENT_IP_ADDR, clientIpAdr);
        params.put(RequestParameters.LANGUAGE, language);
        params.put(RequestParameters.DESCRIPTION, description);
        params.put(RequestParameters.BILLER_CLIENT_ID, billerClientId);
        params.put(RequestParameters.PERSPAYEE_EXPIRY, perspayeeExpiry);
        params.put(RequestParameters.PERSPAYEE_GEN, perspayeeGen);
        params.put(RequestParameters.PERSPAYEE_OVERWRITE, perspayeeOverwrite);
        params.put(RequestParameters.MSG_TYPE, TransactionTypes.SMS.toString());

        ResponseEntity<String> response = performRequest(merchantHandlerURL, params);
        return ResponseMapper.mapResponseToResponseDTO(response.getBody());
    }

    public ResponseDTO registerRegularDmsTransaction(int amount, int currency, String clientIpAdr, String language, String description, String billerClientId, String perspayeeExpiry, String perspayeeGen, String perspayeeOverwrite) {

        Map<String, String> params = new HashMap<>();
        params.put(RequestParameters.COMMAND, CommandTypes.REGISTER_REGULAR_DMS_TRANSACTION);
        params.put(RequestParameters.AMOUNT, String.valueOf(amount));
        params.put(RequestParameters.CURRENCY, String.valueOf(currency));
        params.put(RequestParameters.CLIENT_IP_ADDR, clientIpAdr);
        params.put(RequestParameters.LANGUAGE, language);
        params.put(RequestParameters.DESCRIPTION, description);
        params.put(RequestParameters.BILLER_CLIENT_ID, billerClientId);
        params.put(RequestParameters.PERSPAYEE_EXPIRY, perspayeeExpiry);
        params.put(RequestParameters.PERSPAYEE_GEN, perspayeeGen);
        params.put(RequestParameters.PERSPAYEE_OVERWRITE, perspayeeOverwrite);
        params.put(RequestParameters.MSG_TYPE, TransactionTypes.DMS.toString());

        ResponseEntity<String> response = performRequest(merchantHandlerURL, params);
        return ResponseMapper.mapResponseToResponseDTO(response.getBody());
    }

    public ResponseDTO registerRegularAuthTransaction(int amount, int currency, String clientIpAdr, String language, String description, String billerClientId, String perspayeeExpiry, String perspayeeGen) {

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
        params.put(RequestParameters.MSG_TYPE, TransactionTypes.AUTH.toString());

        ResponseEntity<String> response = performRequest(merchantHandlerURL, params);
        return ResponseMapper.mapResponseToResponseDTO(response.getBody());
    }

    public ResponseEntity<String> makeTemplateTransaction(int amount, int currency, String clientIpAdr, String language, String description, String billerClientId) {

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
