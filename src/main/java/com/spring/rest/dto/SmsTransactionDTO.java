package com.spring.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SmsTransactionDTO extends ResponseDTO{
    @JsonProperty("RESULT_PS")
    private String resultPs;
    @JsonProperty("3DSECURE")
    private String secureStatus;
    @JsonProperty("RRN")
    private String referenceRetrievalNumber;
    @JsonProperty("APPROVAL_CODE")
    private String approvalCode;
    @JsonProperty("CARD_NUMBER")
    private String cardNumber;
    @JsonProperty("MRCH_TRANSACTION_ID")
    private String merchantTransactionId;
}
