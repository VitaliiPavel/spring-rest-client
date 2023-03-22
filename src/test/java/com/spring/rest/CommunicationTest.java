package com.spring.rest;

import com.spring.rest.dto.CloseBusinessDayDTO;
import com.spring.rest.dto.DmsTransactionDTO;
import com.spring.rest.dto.ResponseDTO;
import com.spring.rest.dto.TransactionStatusDTO;

import com.spring.rest.utils.exceptions.NotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
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
        ResponseDTO response = communication.registerSmsTransaction(
                AMOUNT, CURRENCY, CLIENT_IP_ADR, LANGUAGE, DESCRIPTION);
        String trans_id = response.getTransactionId();
        TransactionStatusDTO transactionResponse = communication.getTransactionResult(trans_id, CLIENT_IP_ADR);
        assertNotNull(trans_id);
        assertNotNull(transactionResponse.getResultStatus());
    }

    @Test
    public void registerDmsTransactionGetTransId() {
        ResponseDTO response = communication.registerDmsTransaction(
                CLIENT_IP_ADR, AMOUNT, CURRENCY, DESCRIPTION, LANGUAGE);
        assertNotNull(response.getTransactionId());
    }

    @Test
    public void performRequestException() {
        assertThrows(NotFoundException.class, () -> {
            communication.performRequest("https://maib.ecommerce.md:21440/ecomm/Merchant", new HashMap<>());
        });
    }

    @Test
    public void makeDmsTransactionTest() {
        ResponseDTO response = communication.registerDmsTransaction(
                CLIENT_IP_ADR, AMOUNT, CURRENCY, DESCRIPTION, LANGUAGE);
        String trans_id = response.getTransactionId();
        DmsTransactionDTO makeTransResponse = communication.makeDmsTransaction(CLIENT_IP_ADR, trans_id, AMOUNT, CURRENCY, DESCRIPTION, LANGUAGE);
        String transactionResult = makeTransResponse.getError();
        assertNotNull(trans_id);
        assertNotNull(transactionResult);
    }

    @Test
    public void revertTransactionTest() {
        ResponseDTO response = communication.revertTransaction(TRANS_ID, AMOUNT, "");
        assertNotNull(response.getResultStatus());
        assertNotNull(response.getResultCode());
    }

    @Test
    public void closeDayTest() {
        CloseBusinessDayDTO response = communication.closeDay();
        assertNotNull(response.getResultStatus());
        assertNotNull(response.getResultCode());
    }

    @Test
    public void registerRegularSmsTransactionTest() {
        ResponseDTO response = communication.registerRegularSmsTransaction(
                AMOUNT, CURRENCY, CLIENT_IP_ADR, LANGUAGE, DESCRIPTION, "", PERSPAYEE_EXPIRY, PERSPAYEE_GEN, PERSPAYEE_OVERWRITE);
        assertNotNull(response.getTransactionId());
    }

    @Test
    public void registerRegularDmsTransactionTest() {
        ResponseDTO response = communication.registerRegularDmsTransaction(
                AMOUNT, CURRENCY, CLIENT_IP_ADR, LANGUAGE, DESCRIPTION, "", PERSPAYEE_EXPIRY, PERSPAYEE_GEN, PERSPAYEE_OVERWRITE);
        assertNotNull(response.getTransactionId());
    }

    @Test
    public void registerRegularTransactionTest() {
        ResponseDTO response = communication.registerRegularAuthTransaction(
                AMOUNT, CURRENCY, CLIENT_IP_ADR, LANGUAGE, DESCRIPTION, "", PERSPAYEE_EXPIRY, PERSPAYEE_GEN);
        assertNotNull(response.getTransactionId());
    }

}
