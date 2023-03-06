package com.spring.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemplateTransactionDTO {
    @JsonProperty("TRANSACTION_ID")
    private String transactionId;
    @JsonProperty("RESULT")
    private String result;
    @JsonProperty("RESULT_CODE")
    private String resultCode;
    @JsonProperty("RRN")
    private String referenceRetrievalNumber;
    @JsonProperty("APPROVAL_CODE")
    private String approvalCode;
}
