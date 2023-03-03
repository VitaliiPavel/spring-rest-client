package com.spring.rest;

import com.constants.ResponseParameters;
import com.spring.rest.dto.ResponseDTO;
import com.spring.rest.mapper.ResponseMapper;
import com.spring.rest.utils.StringUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommunicationTest {

    public final int AMOUNT = 400;
    public final int CURRENCY = 498;
    public final String CLIENT_IP_ADR = "127.0.0.1";
    public final String LANGUAGE = "en";
    public final String DESCRIPTION = "PostMan";
    public final String TRANS_ID = "nOq6cnVflSX3ZmYLK42LbOEGHo0=";
    public final String PERSPAYEE_OVERWRITE = "1";
    public final String PERSPAYEE_EXPIRY = "1224";
    public final String PERSPAYEE_GEN = "1";

    @Autowired
    private Communication communication;

    @Test
    public void registerSmsTransactionGetTransIdAndStatus() {
        ResponseEntity<String> response = communication.registerSmsTransaction(
                AMOUNT, CURRENCY, CLIENT_IP_ADR, LANGUAGE, DESCRIPTION);
        Map<String, String> responseMap = StringUtil.convertStringToMap(response.getBody());
        String trans_id = responseMap.get(ResponseParameters.TRANSACTION_ID);

        response = communication.getTransactionResult(trans_id, CLIENT_IP_ADR);
        responseMap = StringUtil.convertStringToMap(response.getBody());
        String transactionStatus = responseMap.get(ResponseParameters.RESULT);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(trans_id != null && trans_id.length() > 0);
        assertTrue(transactionStatus != null && transactionStatus.length() > 0);
    }

    @Test
    public void registerDmsTransactionGetTransId() {
        ResponseEntity<String> response = communication.registerDmsTransaction(
                CLIENT_IP_ADR, AMOUNT, CURRENCY, DESCRIPTION, LANGUAGE);
        ResponseDTO responseDTO = ResponseMapper.mapResponseToResponseDTO(response.getBody());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(responseDTO.getTransactionId() != null && responseDTO.getTransactionId().length() > 0);
    }

    @Test
    public void makeDmsTransactionTest() {
        ResponseEntity<String> response = communication.registerDmsTransaction(
                CLIENT_IP_ADR, AMOUNT, CURRENCY, DESCRIPTION, LANGUAGE);

        Map<String, String> responseMap = StringUtil.convertStringToMap(response.getBody());
        String trans_id = responseMap.get(ResponseParameters.TRANSACTION_ID);

        response = communication.makeDmsTransaction(CLIENT_IP_ADR, trans_id, AMOUNT, CURRENCY, DESCRIPTION, LANGUAGE);
        responseMap = StringUtil.convertStringToMap(response.getBody());
        String transactionResult = responseMap.get(ResponseParameters.ERROR);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(transactionResult != null && transactionResult.length() > 0);
    }

    @Test
    public void revertTransactionTest() {
        ResponseEntity<String> response = communication.revertTransaction(TRANS_ID, AMOUNT, "");
        Map<String, String> responseMap = StringUtil.convertStringToMap(response.getBody());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(responseMap.containsKey(ResponseParameters.RESULT));
        assertTrue(responseMap.containsKey(ResponseParameters.RESULT_CODE));
    }

    @Test
    public void closeDayTest() {
        ResponseEntity<String> response = communication.closeDay();
        Map<String, String> responseMap = StringUtil.convertStringToMap(response.getBody());

        assertTrue(responseMap.containsKey(ResponseParameters.RESULT_CODE));
        assertTrue(responseMap.containsKey(ResponseParameters.RESULT));
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void registerRegularSmsTransactionTest() {
        ResponseEntity<String> response = communication.registerRegularSmsTransaction(
                AMOUNT, CURRENCY, CLIENT_IP_ADR, LANGUAGE, DESCRIPTION, "", PERSPAYEE_EXPIRY, PERSPAYEE_GEN, PERSPAYEE_OVERWRITE);

        Map<String, String> responseMap = StringUtil.convertStringToMap(response.getBody());
        String trans_id = responseMap.get(ResponseParameters.TRANSACTION_ID);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(trans_id != null && trans_id.length() > 0);
    }

    @Test
    public void registerRegularDmsTransactionTest() {
        ResponseEntity<String> response = communication.registerRegularDmsTransaction(
                AMOUNT, CURRENCY, CLIENT_IP_ADR, LANGUAGE, DESCRIPTION, "", PERSPAYEE_EXPIRY, PERSPAYEE_GEN, PERSPAYEE_OVERWRITE);

        Map<String, String> responseMap = StringUtil.convertStringToMap(response.getBody());
        String trans_id = responseMap.get(ResponseParameters.TRANSACTION_ID);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(trans_id != null && trans_id.length() > 0);
    }

    @Test
    public void registerRegularTransactionTest() {
        ResponseEntity<String> response = communication.registerRegularAuthTransaction(
                AMOUNT, CURRENCY, CLIENT_IP_ADR, LANGUAGE, DESCRIPTION, "", PERSPAYEE_EXPIRY, PERSPAYEE_GEN);

        Map<String, String> responseMap = StringUtil.convertStringToMap(response.getBody());
        String trans_id = responseMap.get(ResponseParameters.TRANSACTION_ID);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(trans_id != null && trans_id.length() > 0);
    }


}
