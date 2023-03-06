package com.spring.rest.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.rest.dto.GeneralResponseDTO;
import com.spring.rest.utils.StringUtil;

import java.util.Map;

public final class ResponseMapper {
    public static GeneralResponseDTO mapResponseToResponseDTO(String response) {
        Map<String, String> responseMap = StringUtil.convertStringToMap(response);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(responseMap, GeneralResponseDTO.class);
    }
}
