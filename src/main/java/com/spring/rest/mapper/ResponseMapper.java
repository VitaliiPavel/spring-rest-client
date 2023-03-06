package com.spring.rest.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.rest.dto.*;
import com.spring.rest.utils.StringUtil;

import java.util.Map;

public final class ResponseMapper {
    public static ResponseDTO mapResponseToResponseDTO(String response) {
        Map<String, String> responseMap = StringUtil.convertStringToMap(response);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(responseMap, ResponseDTO.class);
    }
    public static RegisterTransactionDTO mapResponseToRegisterTransactionDTO(String response){
        Map<String, String> responseMap = StringUtil.convertStringToMap(response);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(responseMap, RegisterTransactionDTO.class);
    }
    public static RequestStatusTransactionDTO mapResponseToRequestStatusTransactionDTO(String response){
        Map<String, String> responseMap = StringUtil.convertStringToMap(response);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(responseMap, RequestStatusTransactionDTO.class);
    }
    public static SmsTransactionDTO mapResponseToSmsTransactionDTO(String response){
        Map<String, String> responseMap = StringUtil.convertStringToMap(response);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(responseMap, SmsTransactionDTO.class);
    }
    public static ReversalTransactionDTO mapResponseToReversalTransactionDTO(String response){
        Map<String, String> responseMap = StringUtil.convertStringToMap(response);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(responseMap, ReversalTransactionDTO.class);
    }
    public static CloseDayDTO mapResponseToCloseDayDTO(String response){
        Map<String, String> responseMap = StringUtil.convertStringToMap(response);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(responseMap, CloseDayDTO.class);
    }

}
