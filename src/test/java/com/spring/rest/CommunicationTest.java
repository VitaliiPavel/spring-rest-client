package com.spring.rest;

import com.spring.rest.dto.*;
import com.spring.rest.mapper.ResponseMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;



import static org.junit.jupiter.api.Assertions.*;

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
        ResponseDTO registerTransactionDTO = ResponseMapper.mapResponseToResponseDTO(response.getBody());
        String trans_id = registerTransactionDTO.getTransactionId();

        ResponseEntity<String> transactionResponse = communication.getTransactionResult(trans_id, CLIENT_IP_ADR);
        TransactionStatusDTO transactionStatusDTO = ResponseMapper.mapResponseToTransactionStatusDTO(transactionResponse.getBody());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(HttpStatus.OK, transactionResponse.getStatusCode());
        assertNotNull(trans_id);
        assertNotNull(transactionStatusDTO.getResultStatus());
    }

    @Test
    public void registerDmsTransactionGetTransId() {
        ResponseEntity<String> response = communication.registerDmsTransaction(
                CLIENT_IP_ADR, AMOUNT, CURRENCY, DESCRIPTION, LANGUAGE);
        ResponseDTO registerTransactionDTO = ResponseMapper.mapResponseToResponseDTO(response.getBody());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(registerTransactionDTO.getTransactionId());
    }

    @Test
    public void makeDmsTransactionTest() {
        ResponseEntity<String> response = communication.registerDmsTransaction(
                CLIENT_IP_ADR, AMOUNT, CURRENCY, DESCRIPTION, LANGUAGE);
        ResponseDTO registerTransactionDTO = ResponseMapper.mapResponseToResponseDTO(response.getBody());
        String trans_id = registerTransactionDTO.getTransactionId();

        ResponseEntity<String> makeTransResponse = communication.makeDmsTransaction(CLIENT_IP_ADR, trans_id, AMOUNT, CURRENCY, DESCRIPTION, LANGUAGE);
        DmsTransactionDTO dmsTransactionDTO = ResponseMapper.mapResponseToDmsTransactionDTO(makeTransResponse.getBody());
        String transactionResult = dmsTransactionDTO.getError();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(HttpStatus.OK, makeTransResponse.getStatusCode());
        assertNotNull(trans_id);
        assertNotNull(transactionResult);
    }

    @Test
    public void revertTransactionTest() {
        ResponseEntity<String> response = communication.revertTransaction(TRANS_ID, AMOUNT, "");
        ResponseDTO reversalTransactionDTO = ResponseMapper.mapResponseToResponseDTO(response.getBody());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(reversalTransactionDTO.getResultStatus());
        assertNotNull(reversalTransactionDTO.getResultCode());
    }

    @Test
    public void closeDayTest() {
        ResponseEntity<String> response = communication.closeDay();
        CloseBusinessDayDTO closeBusinessDayDTO = ResponseMapper.mapResponseToCloseDayDTO(response.getBody());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(closeBusinessDayDTO.getResultStatus());
        assertNotNull(closeBusinessDayDTO.getResultCode());
    }

    @Test
    public void registerRegularSmsTransactionTest() {
        ResponseEntity<String> response = communication.registerRegularSmsTransaction(
                AMOUNT, CURRENCY, CLIENT_IP_ADR, LANGUAGE, DESCRIPTION, "", PERSPAYEE_EXPIRY, PERSPAYEE_GEN, PERSPAYEE_OVERWRITE);

        ResponseDTO registerTransactionDTO = ResponseMapper.mapResponseToResponseDTO(response.getBody());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(registerTransactionDTO.getTransactionId());
    }

    @Test
    public void registerRegularDmsTransactionTest() {
        ResponseEntity<String> response = communication.registerRegularDmsTransaction(
                AMOUNT, CURRENCY, CLIENT_IP_ADR, LANGUAGE, DESCRIPTION, "", PERSPAYEE_EXPIRY, PERSPAYEE_GEN, PERSPAYEE_OVERWRITE);

        ResponseDTO registerTransactionDTO = ResponseMapper.mapResponseToResponseDTO(response.getBody());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(registerTransactionDTO.getTransactionId());
    }

    @Test
    public void registerRegularTransactionTest() {
        ResponseEntity<String> response = communication.registerRegularAuthTransaction(
                AMOUNT, CURRENCY, CLIENT_IP_ADR, LANGUAGE, DESCRIPTION, "", PERSPAYEE_EXPIRY, PERSPAYEE_GEN);

        ResponseDTO registerTransactionDTO = ResponseMapper.mapResponseToResponseDTO(response.getBody());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(registerTransactionDTO.getTransactionId());
    }


}
