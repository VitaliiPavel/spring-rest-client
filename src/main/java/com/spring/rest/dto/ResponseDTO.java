package com.spring.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.rest.enums.ResultStatuses;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO {
    @JsonProperty("TRANSACTION_ID")
    private String transactionId;
    @JsonProperty("RESULT")
    private ResultStatuses resultStatus;
    @JsonProperty("RESULT_CODE")
    private String resultCode;
    @JsonProperty("error")
    private String error;
}
