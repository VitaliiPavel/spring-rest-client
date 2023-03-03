package com.spring.rest.mapper;

import com.spring.rest.constants.ResponseParameters;
import com.spring.rest.dto.ResponseDTO;
import com.spring.rest.utils.StringUtil;

import java.util.HashMap;
import java.util.Map;

public final class ResponseMapper {
        public static final ResponseDTO mapResponseToResponseDTO(String response){
            ResponseDTO responseDTO = new ResponseDTO();
            Map<String,String> responseMap = StringUtil.convertStringToMap(response);
            responseDTO.setTransactionId(responseMap.get(ResponseParameters.TRANSACTION_ID));
            return responseDTO;
        }
}
