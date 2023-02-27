package com.spring.rest;


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

    @Autowired
    private Communication communication;

    @Test
    public void registerSmsTransactionTest() {
        ResponseEntity<String> response = communication.registerSmsTransaction(
                AMOUNT, CURRENCY, CLIENT_IP_ADR, LANGUAGE, DESCRIPTION);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void registerSmsTransactionGetTransId() {
        ResponseEntity<String> response = communication.registerSmsTransaction(
                AMOUNT, CURRENCY, CLIENT_IP_ADR, LANGUAGE, DESCRIPTION);

        Map<String, String> responseMap = StringUtil.convertStringToMap(response.getBody());
        String trans_id = responseMap.get("TRANSACTION_ID");

        assertTrue(trans_id != null && trans_id.length() > 0);
    }

    @Test
    public void getTransactionResultTest() {
        ResponseEntity<String> response = communication.getTransactionResult(TRANS_ID, CLIENT_IP_ADR);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void registerDmsTransactionTest() {
        ResponseEntity<String> response = communication.registerDmsTransaction(
                CLIENT_IP_ADR, AMOUNT, CURRENCY, DESCRIPTION, LANGUAGE);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    @Test
    public void registerDmsTransactionGetTransId() {
        ResponseEntity<String> response = communication.registerDmsTransaction(
                CLIENT_IP_ADR, AMOUNT, CURRENCY, DESCRIPTION, LANGUAGE);

        Map<String, String> responseMap = StringUtil.convertStringToMap(response.getBody());
        String trans_id = responseMap.get("TRANSACTION_ID");

        assertTrue(trans_id != null && trans_id.length() > 0);
    }

    @Test
    public void makeDmsTransactionTest() {
        ResponseEntity<String> response = communication.makeDmsTransaction(
                CLIENT_IP_ADR, TRANS_ID, AMOUNT, CURRENCY, DESCRIPTION, LANGUAGE);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void revertTransactionTest() {
        ResponseEntity<String> response = communication.revertTransaction(TRANS_ID, AMOUNT, "");
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void closeDayTest() {
        ResponseEntity<String> response = communication.closeDay();
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void registerRegularSmsTransactionTest() {
        ResponseEntity<String> response = communication.registerRegularSmsTransaction(
                AMOUNT, CURRENCY, CLIENT_IP_ADR, LANGUAGE, DESCRIPTION, "", "", "", "");
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void registerRegularDmsTransactionTest() {
        ResponseEntity<String> response = communication.registerRegularDmsTransaction(
                AMOUNT, CURRENCY, CLIENT_IP_ADR, LANGUAGE, DESCRIPTION, "", "", "", "");
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void registerRegularTransactionTest() {
        ResponseEntity<String> response = communication.registerRegularTransaction(
                AMOUNT, CURRENCY, CLIENT_IP_ADR, LANGUAGE, DESCRIPTION, "", "", "");
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void makeTransactionTest() {
        ResponseEntity<String> response = communication.makeTransaction(
                AMOUNT, CURRENCY, CLIENT_IP_ADR, LANGUAGE, DESCRIPTION, "");
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void deleteTransactionTest() {
        ResponseEntity<String> response = communication.deleteTransaction("");
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}
