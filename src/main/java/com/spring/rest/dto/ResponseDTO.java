package com.spring.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO {
    @JsonProperty("TRANSACTION_ID")
    private String transactionId;
    @JsonProperty("RESULT")
    private String result;
    @JsonProperty("RESULT_CODE")
    private String resultCode;
    @JsonProperty("error")
    private String error;
}
