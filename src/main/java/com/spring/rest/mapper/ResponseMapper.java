package com.spring.rest.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.rest.dto.*;
import com.spring.rest.utils.StringUtil;

import java.util.Map;

public final class ResponseMapper {
    public static ResponseDTO mapResponseToResponseDTO(String response) {
        Map<String, String> responseMap = StringUtil.convertStringToMap(response);
        return new ObjectMapper().convertValue(responseMap, ResponseDTO.class);
    }
    public static TransactionStatusDTO mapResponseToTransactionStatusDTO(String response){
        Map<String, String> responseMap = StringUtil.convertStringToMap(response);
        return new ObjectMapper().convertValue(responseMap, TransactionStatusDTO.class);
    }
    public static DmsTransactionDTO mapResponseToDmsTransactionDTO(String response){
        Map<String, String> responseMap = StringUtil.convertStringToMap(response);
        return new ObjectMapper().convertValue(responseMap, DmsTransactionDTO.class);
    }
    public static CloseBusinessDayDTO mapResponseToCloseDayDTO(String response){
        Map<String, String> responseMap = StringUtil.convertStringToMap(response);
        return new ObjectMapper().convertValue(responseMap, CloseBusinessDayDTO.class);
    }
    public static TemplateTransactionDTO mapResponseToTemplateTransactionDTO(String response){
        Map<String, String> responseMap = StringUtil.convertStringToMap(response);
        return new ObjectMapper().convertValue(responseMap, TemplateTransactionDTO.class);
    }


}
